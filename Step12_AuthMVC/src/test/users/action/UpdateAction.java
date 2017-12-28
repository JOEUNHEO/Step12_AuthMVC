package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UpdateAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. updateForm 에 입력한 id, pwd, email 값을 가져온다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		UsersDto dto = new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		//2. DB 에 있는 회원 정보를 수정한다.
		boolean isSuccess = UsersDao.getInstance().update(dto);
		
		if(isSuccess) {// 수정에 성공하면,
			request.setAttribute("msg", "회원 정보가 수정되었습니다.");
		}else {// 수정에 실패하면,
			request.setAttribute("msg", "회원 정보 수정에 실패했습니다.");
		}
		
		// url 을 request 에 담는다.
		String cPath = request.getContextPath();
		
		request.setAttribute("url", cPath+"/users/private/info.do");
		//3. forward 한다.
		return new ActionForward("/views/users/private/alert.jsp");
	}

}
