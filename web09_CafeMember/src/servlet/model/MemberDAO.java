package servlet.model;
//3개 + 공통 2개
// 나중에 필요한 거 추가

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public interface MemberDAO {
	//공통
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	//비지니스로직
	void registerMember(MemberVO vo) throws SQLException;
	ArrayList<MemberVO> showAllMember() throws SQLException;
	MemberVO findByIdMember(String id) throws SQLException;
	
	

}
