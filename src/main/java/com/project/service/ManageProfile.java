package com.project.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.project.config.Singleton;
import com.project.entity.User;
@WebServlet("/manage_profile")
public class ManageProfile extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession session = req.getSession(true);
		User user=(User)session.getAttribute("user");
		user.setUserName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		boolean result = Singleton.getUserDao().updateUser(user);
		if(result) {
			resp.sendRedirect("manageprofile.jsp");
		}else {
			req.setAttribute("error", "failed to update");
	        req.getRequestDispatcher("update_user.jsp").forward(req, resp);
			
		}
		
	}

}
