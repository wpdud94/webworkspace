package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum =Integer.parseInt(request.getParameter("itemnumber"));
		
		boolean result = ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+result);
		
		Item item=ItemDao.getInstance().getItem(itemnum);
		System.out.println("Item "+item);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}
}




