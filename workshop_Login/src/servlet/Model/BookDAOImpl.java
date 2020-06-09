package servlet.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;;

public class BookDAOImpl implements BookDAO{
	DataSource ds;
	//싱글톤
	private static BookDAOImpl bookDao = new BookDAOImpl() ;

	private BookDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			System.out.println("DataSource Loading Fail");
		}
	}
	public static BookDAOImpl getInstance() {
		return bookDao;
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
	public void registerBook(BookVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String query = "INSERT INTO book VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getCurrency());
			ps.setString(10, vo.getDescription());
			
			System.out.println(ps.executeUpdate()+" 권의 책이 등록됐습니다.");
			
		}finally {
			closeAll(ps, conn);
		}
		
	}
	/*public static void main(String[] args) throws SQLException {
		BookDAOImpl bookDao = new BookDAOImpl();
		bookDao.registerBook(new BookVO("11", "11", "11", "11", "2020-02-02", "11", "11", 1, "11", "11"));
	}
*/
}
