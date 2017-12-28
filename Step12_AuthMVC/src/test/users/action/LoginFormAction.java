package test.users.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class LoginFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
				
		//1. 로그인후 리다일렉트 이동할 url 주소를 읽어온다.
		String url = request.getParameter("url");
		if(url == null){// 만일 없으면
			// 인덱스 페이지로 이동 될 수 있도록
			url = request.getContextPath()+"/home.do";
		}
		
		// url 을 request 에 담는다.
		request.setAttribute("url", url);
		
		//쿠키에 저장된 아이디를 담을 변수
		String savedId = "";
		
		//2. request 객체에 담겨서 전달된 쿠키 목록을 읽어온다.
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length > 0){
			for(Cookie tmp:cookies){
				if(tmp.getName().equals("savedId")){
					//쿠키 value 를 읽어와서 변수 savedId에 담는다.
					savedId = tmp.getValue();	
				}
			}
		}
		
		//저장한 Id를 request 에 담는다.
		request.setAttribute("savedId", savedId);
		//3. forward 한다.
		return new ActionForward("/views/users/login_form.jsp");
	}

}
