package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.model.DAO;
import pattern.model.NoteBook;

public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 폼값
		String path ="find_fail.jsp";
		String model = request.getParameter("model");
		DAO dao = DAO.getInstance();
		NoteBook notebook = dao.findNoteBook(model);
		request.setAttribute("notebook", notebook);
		if(notebook!=null) path = "find_ok.jsp";
	
		return path;
	}

}
