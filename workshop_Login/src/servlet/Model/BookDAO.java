package servlet.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.mysql.cj.protocol.Resultset;

/**
 * 
 * @author KJY
 * @version 1.Book DB와 연관된 오브젝트. 첫 버전 
 */
public interface BookDAO {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	//비지니스로직
	//1. 책 등록
	void registerBook(BookVO vo) throws SQLException;
	ArrayList<BookVO> AllBooks() throws SQLException;
}
