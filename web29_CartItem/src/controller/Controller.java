package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
