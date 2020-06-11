package pattern.model;

import java.sql.SQLException;

public class DAO {
	private static DAO dao = new DAO();
	private DAO() {
		
	}
	public static DAO getInstance() {
		return dao;
	}
	
	public NoteBook findNoteBook(String model) throws SQLException{
		//DB 연결됐다고 하고
		System.out.println(model);
		NoteBook notebook = new NoteBook(model, 15000000);
		return notebook;
	}
}
