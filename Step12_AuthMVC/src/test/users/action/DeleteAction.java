package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;

public class DeleteAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 세션 초기화
		HttpSession session = request.getSession();
		//1. session 에 담긴 id 를 가져온다.
		String id = (String)session.getAttribute("id");
		//2. DB 에 회원 정보를 삭제한다.
		boolean isSuccess = UsersDao.getInstance().delete(id);
		
		if(isSuccess) {// 삭제에 성공하면,
			request.setAttribute("msg", id+"회원님 탈퇴 처리 되었습니다.");
			session.invalidate(); // session 에 담긴 모든 정보를 없앤다.
			
		}else {// 삭제에 실패하면,
			request.setAttribute("msg", id+"회원님 탈퇴 처리에 실패했습니다.");
		}
		
		// url 을 request 에 담는다.
		String cPath = request.getContextPath();
		
		request.setAttribute("url", cPath+"/home.do");
		//3. forward 한다.
		return new ActionForward("/views/users/private/alert.jsp");
	}

}
