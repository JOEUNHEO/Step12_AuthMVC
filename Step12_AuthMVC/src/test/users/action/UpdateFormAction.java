package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UpdateFormAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. session 에 담겨진 id 를 가져온다.
		String id = (String)request.getSession().getAttribute("id");
		//2. DB 에 저장된 회원 정보를 id 로 검색한다. 
		UsersDto dto = UsersDao.getInstance().getData(id);
		//3. DB 에서 찾은 회원 정보를 request 에 담는다.
		request.setAttribute("dto", dto);
		//4. forward 한다.
		return new ActionForward("/views/users/private/update_form.jsp");
	}

}
