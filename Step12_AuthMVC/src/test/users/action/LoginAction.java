package test.users.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class LoginAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 입력한 id, pwd 값을 가져온다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
				
		UsersDto dto = new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		
		//2. DB 에서 정보가 유효한지 찾는다.
		boolean isValid = UsersDao.getInstance().isValid(dto);
		
		if(isValid) {// DB 에 가입 정보가 있다면,
			
			// 세션 초기화
			HttpSession session =  request.getSession();
			// id를 세션에 담는다.
			session.setAttribute("id", id);
			// 알림을 request 에 담는다.
			request.setAttribute("msg", id+"님 로그인 되었습니다.");
			// 아이디 저장에 체크한 값을 가져온다.
			String isSave = request.getParameter("isSave");
			
			if(isSave != null) {//아이디 저장에 체크했으면
				// 쿠키를 생성한다.
				Cookie cookie = new Cookie("savedId", id);
				// 쿠키 유지 시간을 60초로 설정한다.
				cookie.setMaxAge(60);
				// response 에 쿠키를 추가한다.
				response.addCookie(cookie);
			}
				
		}else {// DB 에 가입 정보가 없거나 불일치하면
			// 알림을 request 에 담는다.
			request.setAttribute("msg", "아이디 혹은 비밀번호가 틀려요");
		}
		
		// 로그인 성공후 이동할 url
		String url = request.getParameter("url");
		// url 을 request 에 담는다.
		request.setAttribute("url", url);
		//3. forward 한다.	
		return new ActionForward("/views/users/alert.jsp?");
	}

}
