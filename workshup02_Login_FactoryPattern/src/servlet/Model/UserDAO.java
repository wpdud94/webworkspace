package servlet.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mysql.cj.protocol.Resultset;


/**
 * 
 * @author KJY
 * @version 1.User DB와 연관된 오브젝트. 첫 버전 
 */
public interface UserDAO {
	/*Connection getConnetion() throws SQLException;*/
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	//비지니스로직
	//1.로그인
	UserVO login(String id, String password) throws SQLException;
	
	
	
	
}
