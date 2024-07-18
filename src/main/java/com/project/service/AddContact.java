package com.project.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.config.Singleton;
import com.project.entity.Contact;
import com.project.entity.User;
@WebServlet("/addcontact")
public class AddContact extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("contactName");
		long mob=Long.parseLong(req.getParameter("contactNumber"));
		HttpSession session = req.getSession(true);
		User user=(User)session.getAttribute("user");
		
		Contact contact=new Contact();
		contact.setContactName(name);
		contact.setCotactNumber(mob);
		contact.setUser(user);
		
		boolean result=Singleton.getContactDao().saveContact(contact);
		if(result) {
			resp.sendRedirect("home.jsp");
			
		}
		else {
			req.setAttribute("error","failed to add");
			req.getRequestDispatcher("addcontact.jsp").forward(req, resp);
		}
	}

}
