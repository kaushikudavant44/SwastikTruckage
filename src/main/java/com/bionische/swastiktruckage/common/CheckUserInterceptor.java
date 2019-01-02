package com.bionische.swastiktruckage.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bionische.swastiktruckage.mastermodel.OfficeStaff;

public class CheckUserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {

		HttpSession session = request.getSession();

		String path = request.getRequestURI().substring(request.getContextPath().length());

		if (path.startsWith("/pdf")) {
			return true;
		}

		try {
			String resourcesPath = path.substring(1, 4);

			if (resourcesPath.equalsIgnoreCase("res")) {

				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (path.equalsIgnoreCase("/sessionTimeOut") || path.equalsIgnoreCase("/")
				|| path.equalsIgnoreCase("/staffLoginProcess")

		)

		{

			return true;
		} else {

			OfficeStaff officeStaff = null;

			try {

				officeStaff = (OfficeStaff) session.getAttribute("staffDetails");

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

				response.sendRedirect(request.getContextPath() + "/sessionTimeOut");
				return false;
			}

			if (officeStaff == null) {

				response.sendRedirect(request.getContextPath() + "/sessionTimeOut");
				return false;
			}

			else {

				return true;
			}

			/*
			 * try { if(request.getServletPath().equals("/") ||
			 * request.getServletPath().equals("/loginProcess")
			 * ||request.getServletPath().equals("/logout")
			 * ||request.getServletPath().equals("/login")){
			 * //||request.getServletPath().equals("/logout")
			 * System.out.println("Login request"); return true; } else if( userObj == null
			 * ) { System.out.println("Session Expired");
			 * 
			 * // request.setAttribute("emassage", "login failed");
			 * response.sendRedirect(request.getContextPath()+"/sessionTimeOut");
			 * 
			 * return false; }else{ return true; } }catch (Exception e) {
			 * e.printStackTrace();
			 * response.sendRedirect(request.getContextPath()+"/sessionTimeOut");
			 * 
			 * return false; }
			 */

		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		super.postHandle(request, response, handler, modelAndView);
	}

}