package model;
/**
 * 
 * @author Playdata
 * 상품 관련 비지니스로직을 담은 DAO
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DataSourceManager;

public class ItemDao {
	private DataSource ds;
	
	private static ItemDao dao = new ItemDao();
	private ItemDao() {
		//공장 받기
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static ItemDao getInstance() {
		return dao;
	}
	//공통... Connection, closeAll
	public Connection getConnection() throws SQLException {
		System.out.println("DB Connection Success");
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	//가변
	public ArrayList<Item> getAllItem() throws SQLException{
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		try {
			conn = getConnection();
			String query = "SELECT item_id, item_name, price, description, picture_url, count FROM item";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Item(rs.getInt("item_id"), 
						rs.getString("item_name"),
						rs.getInt("price"),
						rs.getString("description"),
						rs.getString("picture_url"),
						rs.getInt("count")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}//getAllItem
	
	public Item getItem(int itemNumber) throws SQLException {
		Item item = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		try {
			conn=getConnection();
			String query = "SELECT * FROM item WHERE item_id = ?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, itemNumber);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				item = new Item(rs.getInt("item_id"), 
						rs.getString("item_name"),
						rs.getInt("price"),
						rs.getString("description"),
						rs.getString("picture_url"),
						rs.getInt("count"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return item;
	}//getItem
	
	public boolean plusCount(int itemNumber) throws SQLException{
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn=getConnection();
			String query = "UPDATE item SET count = count+1 WHERE item_id =? ";
			ps=conn.prepareStatement(query);
			ps.setInt(1, itemNumber);
			int row = ps.executeUpdate();
			if(row>0) result=true;
		}finally {
			closeAll(ps, conn);
		}
		return result;
	}//plusCount
	
	
	
}
