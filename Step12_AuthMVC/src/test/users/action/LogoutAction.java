package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;

public class LogoutAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//세션 초기화		
		HttpSession session = request.getSession();
		//1. session 에 저장된 id 를 지운다.
		session.removeAttribute("id");
		// 알림을 request 에 담는다.
		request.setAttribute("msg","로그 아웃 되었습니다.");
		// url 을  request 에 담는다.
		String cPath = request.getContextPath();
		
		request.setAttribute("url", cPath+"/home.do");
		//2. forward 한다.
		return new ActionForward("/views/users/alert.jsp");
	}

}
