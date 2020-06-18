package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemInfoController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
		boolean result = false;
		//System.out.println(itemNumber);
		result=ItemDao.getInstance().plusCount(itemNumber);
		System.out.println("count update? "+result);
		
		Item item =ItemDao.getInstance().getItem(itemNumber);
		System.out.println("Item : "+item);
		
		///////////////오늘 본 상품 정보를 저장하는 쿠키 로직////////////////////////////////
		//1. 쿠키 생성 + 쿠키 보내기 to web browser
		Cookie cookie = new Cookie("fruitshop"+itemNumber, item.getUrl());
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		
		
		request.setAttribute("item", item);
		return new ModelAndView("itemInfo.jsp");
	}

}
