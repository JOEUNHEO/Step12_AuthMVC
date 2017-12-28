package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * 	중간에 클라이언트의 요청을 가로 채서 작업을 할 객체 설계
 * 
 * 	- javax.servlet.Filter 인터페이스를 구현해서 만든다. 
 */
@WebFilter({"/users/private/*"})// private 폴더내에 있는 jsp로 요청하기 전에 Filter 실행!
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//필터가 수행이 될 때 호출되는 메소드
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//원래 type 으로 casting
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//HttpSession 객체의 참조값 얻어오기
		HttpSession session = request.getSession();
		//Context 경로 얻어오기
		String cPath = request.getContextPath();
		System.out.println("cPath:"+cPath);
		//원래 요청 url(url) 정보 얻어오기
		String url = request.getRequestURI();
		System.out.println("url:"+url);
		//session 에 로그인 정보가 있는지 여부를 확인해서
		if(session.getAttribute("id") == null) {
			//로그인 페이지의 경로 구성
			String path = cPath+"/users/login_form.do?url="+url;//원래 요청 경로를 달고 가는 것임!(로그인 하고 원래 경로로 이동하기 위해)
			//로그인 페이지로 이동 시킨다.
			response.sendRedirect(path);
		}else {
			//원래 하려던 작업 진행 시키기
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
