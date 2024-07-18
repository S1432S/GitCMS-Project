package com.project.config;

import com.project.dao.ContactDao;
import com.project.dao.UserDao;

public class Singleton {
	private static UserDao userDao;
	private static ContactDao contactDao;
	private Singleton() {
		
	}
	public static synchronized UserDao getUserDao() {
		if(userDao==null) {
			userDao=new UserDao();
		}
		return userDao;
		
		
	}
	public static synchronized ContactDao getContactDao() {
		if(contactDao==null) {
			contactDao=new ContactDao();
		}
		return contactDao;
	}

}
