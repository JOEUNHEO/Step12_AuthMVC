package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;

public class CheckIdAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. login_form 에 입력한 id 값을 가져온다.
		String id = request.getParameter("id");
		//2. DB 에 같은 id 가 있는지 확인한다.
		boolean isValid = UsersDao.getInstance().checkId(id);
		
		if(isValid){// 같은 id 가 있으면,
			request.setAttribute("msg", "이미 사용하는 아이디입니다.");
		}else {// 같은 id 가 없으면,
			request.setAttribute("msg", "사용 가능한 아이디 입니다.");
		}
		//3. forward 한다.
		return new ActionForward("/views/users/checkid.jsp");
	}

}
