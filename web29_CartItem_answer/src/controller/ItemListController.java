package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<Item> list=ItemDao.getInstance().getAllItem();
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}
}
