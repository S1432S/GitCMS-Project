package com.project.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.Singleton;
import com.project.entity.Contact;
@WebServlet("/update")
public class UpdateContact extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("contactName");
		long mob=Long.parseLong(req.getParameter("contactNumber"));
		Contact contact = Singleton.getContactDao().getContact(id);
		contact.setContactName(name);
		contact.setCotactNumber(mob);
		
		boolean result = Singleton.getContactDao().updateContact(contact);
		if(result) {
			resp.sendRedirect("manage_contact");
		}
		else {
			
		}
		
		
	}

}
