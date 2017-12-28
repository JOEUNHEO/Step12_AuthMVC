package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*
 * 	회원가입 폼을 출력해 주는 Action 
 */
public class SignupFormAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//회원 가입 폼을 출력해 주는 페이지로 forward 할 수 있도록
		return new ActionForward("/views/users/signup_form.jsp");
	}

}
