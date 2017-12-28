package test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class HomeAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//home.jsp 페이지로 forward 이동해서 응답할 수 있도록
		ActionForward af = new ActionForward("/views/home.jsp");
		
		return af;
	}

}
