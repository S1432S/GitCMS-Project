package com.project.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	private static EntityManagerFactory factory;

	private EMFSingleton() {

	}

	public static synchronized EntityManagerFactory getFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("abc");
		}
		return factory;
	}

}
