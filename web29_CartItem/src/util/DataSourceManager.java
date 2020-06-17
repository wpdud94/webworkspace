package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author Playdata
 * JNDI API(naming service)를 통해 DataSource를 리턴받는 클래스
 * 싱글톤 구사
 */
public class DataSourceManager {
	private DataSource ds;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		//InitialContext 객체의 lookup을 이용해서 ds 하나 받아오는 로직
		
		try {
			Context ic = new InitialContext();
			ds=(DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup Success");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail");
		}
		
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getConnection() {
		return ds;
	}
}
