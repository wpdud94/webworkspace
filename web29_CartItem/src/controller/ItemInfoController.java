package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemInfoController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
		//System.out.println(itemNumber);
		ItemDao.getInstance().plusCount(itemNumber);
		Item item =ItemDao.getInstance().getItem(itemNumber);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemInfo.jsp");
	}

}
