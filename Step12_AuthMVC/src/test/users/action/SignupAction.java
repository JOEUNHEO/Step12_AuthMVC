package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class SignupAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 폼 전송되는 내용을 읽어와서
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		UsersDto dto = new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		//2. DB 에 저장하고
		boolean isSuccess = UsersDao.getInstance().insert(dto);
		
		if(isSuccess) {// DB 저장에 성공하면
			request.setAttribute("msg", id+"님 정보가 저장되었습니다.");
		}else {// DB 저장에 실패하면
			request.setAttribute("msg", "회원 정보 저장에 실패되었습니다.");
		}
		// url 을 request 에 담는다.
		String cPath = request.getContextPath();
		
		request.setAttribute("url", cPath+"/home.do");
		//3. forward 한다.
		return new ActionForward("/views/users/alert.jsp");
	}

}
