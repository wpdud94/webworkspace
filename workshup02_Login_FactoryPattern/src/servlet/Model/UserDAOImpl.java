package servlet.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;
import com.sun.corba.se.impl.ior.GenericTaggedComponent;


public class UserDAOImpl implements UserDAO {
	DataSource ds;
	
	//싱글톤
	private static UserDAOImpl userDao = new UserDAOImpl() ;

	private UserDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			System.out.println("DataSource Loading Fail");
		}
	}
	public static UserDAOImpl getInstance() {
		return userDao;
	}
	
	public Connection getConnection() throws SQLException {
		System.out.println("DB Connection");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public UserVO login(String id, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT userId, password, name, email FROM userinfo WHERE userId=? AND password =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				vo =new UserVO(rs.getString("userId"), 
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getString("email"));
			}
			
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
}
