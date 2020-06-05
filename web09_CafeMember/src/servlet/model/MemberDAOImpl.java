package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {
	//싱글톤
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connection...");
		return conn;
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
		Connection conn = getConnection();
		String query = "INSERT INTO member(id, password, name, address) VALUES(?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddr());
		
		System.out.println(ps.executeUpdate()+" 명 등록 완료");
		
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection conn = getConnection();
		String query = "SELECT id, password, name, address FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address")));
		}
		return list;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		MemberVO vo = new MemberVO();
		
		Connection conn = getConnection();
		String query = "SELECT id, password, name, address FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddr(rs.getString("address"));
		}
		return vo;
	}
	
	public static void main(String[] args) throws SQLException {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//dao.registerMember(new MemberVO("korea", "1122", "장나라", "중국"));
		System.out.println(dao.showAllMember());
		System.out.println(dao.findByIdMember("korea"));
	}

}
