<<<<<<< HEAD
package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

public class MemberDAOImpl implements MemberDAO{
	private DataSource ds;
	
	//싱글톤...
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		try {
			//Naming Service(JNDI API)...javax.naming.Context
			InitialContext ic = new InitialContext();			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup 성공...");
		}catch(NamingException e) {
			System.out.println("DataSource  Lookup 실패...");
		}
	}	
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {		
		System.out.println("디비연결 성공....");
		return ds.getConnection(); //공장에서 하나의 Connection을 빌려서 나온다.
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "INSERT INTO member VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM member";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....showAllMember..");
					
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"), 
									  rs.getString("password"), 
									  rs.getString("name"), 
									  rs.getString("address")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try{
			conn = getConnection();
			String query = "SELECT * FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....findByIdMember..");
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				vo = new MemberVO(id, 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}//

	//login() 추가...
	public MemberVO login(String id, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM member WHERE id=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id, 
								  password, 
								  rs.getString("name"), 
								  rs.getString("address"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	public void udpateMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "UPDATE member SET id=?, password=?, name=?, address=? where id=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}
	
	public boolean idExist(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			String query = "SELECT id FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			return rs.next();
		}finally{			
			closeAll(rs, ps, conn);
		}
	}//
}
















=======
package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

public class MemberDAOImpl implements MemberDAO{
	private DataSource ds;
	
	//싱글톤...
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		try {
			//Naming Service(JNDI API)...javax.naming.Context
			InitialContext ic = new InitialContext();			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup 성공...");
		}catch(NamingException e) {
			System.out.println("DataSource  Lookup 실패...");
		}
	}	
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {		
		System.out.println("디비연결 성공....");
		return ds.getConnection(); //공장에서 하나의 Connection을 빌려서 나온다.
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "INSERT INTO member VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM member";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....showAllMember..");
					
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"), 
									  rs.getString("password"), 
									  rs.getString("name"), 
									  rs.getString("address")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try{
			conn = getConnection();
			String query = "SELECT * FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....findByIdMember..");
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				vo = new MemberVO(id, 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}//

	//login() 추가...
	public MemberVO login(String id, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM member WHERE id=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id, 
								  password, 
								  rs.getString("name"), 
								  rs.getString("address"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	public void udpateMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "UPDATE member SET id=?, password=?, name=?, address=? where id=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}
	
	public boolean idExist(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			String query = "SELECT id FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			return rs.next();
		}finally{			
			closeAll(rs, ps, conn);
		}
	}//
}
















>>>>>>> d9ea64e93bef5caf88d823372a320ce5c91403dc
