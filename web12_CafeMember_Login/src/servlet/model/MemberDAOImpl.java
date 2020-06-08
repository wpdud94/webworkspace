package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {
	private DataSource ds;
	//싱글톤
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		try {
			//Naming Service(JNDI Service, API)...javax.naming.Context
			InitialContext ic = new InitialContext();
			
			ds=(DataSource) ic.lookup("java:comp/env/jdbc/mysql"); // 클래스 하나만 올리기에 필드 선언 괜츈
		}catch(NamingException e) {
			System.out.println("DataSource Loading Fail...");
		}
		
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("DB Connection Success...");
		return ds.getConnection();//공장에서 하나의 Connection을 빌려서 나온다
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
		conn = getConnection();
		String query = "INSERT INTO member(id, password, name, address) VALUES(?,?,?,?);";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddr());
		
		System.out.println(ps.executeUpdate()+" 명 등록 완료");
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "SELECT id, password, name, address FROM member";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address")));
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
		
		try {
			conn = getConnection();
			String query = "SELECT id, password, name, address FROM member WHERE id = ?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddr(rs.getString("address"));
		}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	public static void main(String[] args) throws SQLException {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//dao.registerMember(new MemberVO("korea", "1122", "장나라", "중국"));
		System.out.println(dao.showAllMember());
		System.out.println(dao.findByIdMember("korea"));
	}
	
	public MemberVO login(String id, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT id, name, address FROM member WHERE id=? AND password =?";
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id, password, rs.getString("name"), rs.getString("address"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
}
