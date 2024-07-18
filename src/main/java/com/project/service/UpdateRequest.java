package com.project.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.Singleton;
import com.project.entity.Contact;
@WebServlet("/update_request")
public class UpdateRequest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Contact contact = Singleton.getContactDao().getContact(id);
		if(contact!=null) {
			req.setAttribute("record", contact);
			req.getRequestDispatcher("updatecontact.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("error","contact not found");
			req.getRequestDispatcher("manage_contact.jsp").forward(req, resp);
		}
	}

}
