package servlet.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

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
	
	public ArrayList<BookVO> AllBooks() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		try {
			conn=getConnection();
			String query = "SELECT * FROM book";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO(
						rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"), 
						rs.getString("nation"), 
						rs.getString("publish_date"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"), 
						rs.getString("currency"), 
						rs.getString("description"));
				list.add(vo);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<BookVO> findBook(String searchType, String searchContent) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String query="";
		try {
			conn=getConnection();
			StringBuilder sb = new StringBuilder();	
			if(searchType.equals("all")) {
				query = "select * FROM book WHERE title Like ? OR publisher Like ? OR price Like ?";
				ps=conn.prepareStatement(query);
				
				ps.setString(1, "%"+searchContent+"%");
				ps.setString(2, "%"+searchContent+"%");
				ps.setString(3, "%"+searchContent+"%");
				System.out.println("%"+searchContent+"%");
				
			}else if(searchType.equals("title")){
				query="select * FROM book WHERE title Like ?";
				ps=conn.prepareStatement(query);
				ps.setString(1, "%"+searchContent+"%");
			}
			else if(searchType.equals("publisher")){
				query="select * FROM book WHERE publisher Like ?";
				ps=conn.prepareStatement(query);
				ps.setString(1, "%"+searchContent+"%");
			}else if(searchType.equals("price")){
				query="select * FROM book WHERE price Like ?";
				ps=conn.prepareStatement(query);
				ps.setString(1, "%"+searchContent+"%");
			}
			//System.out.println("1");
			rs=ps.executeQuery();
			//System.out.println("2");
			//System.out.println(query);
			while(rs.next()) {
				list.add(new BookVO(
						rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"), 
						rs.getString("nation"), 
						rs.getString("publish_date"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"), 
						rs.getString("currency"), 
						rs.getString("description")));
			}
			System.out.println(list);

		}finally {
			closeAll(rs, ps, conn);
		}
		
		return list;
	}
	
	public BookVO findBook(String isbn) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BookVO vo = null;
		try {
			conn=getConnection();
			String query = "SELECT * FROM book WHERE isbn =?";
			ps=conn.prepareStatement(query);
			ps.setString(1, isbn);
			rs=ps.executeQuery();
			if(rs.next()) {
				vo = new BookVO(
					rs.getString("isbn"),
					rs.getString("title"),
					rs.getString("catalogue"), 
					rs.getString("nation"), 
					rs.getString("publish_date"),
					rs.getString("publisher"),
					rs.getString("author"),
					rs.getInt("price"), 
					rs.getString("currency"), 
					rs.getString("description"));
			}

		}finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	/*public static void main(String[] args) throws SQLException {
		BookDAOImpl bookDao = new BookDAOImpl();
		bookDao.registerBook(new BookVO("11", "11", "11", "11", "2020-02-02", "11", "11", 1, "11", "11"));
	}*/

}
