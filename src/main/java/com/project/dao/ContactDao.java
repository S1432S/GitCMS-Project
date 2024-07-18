package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.config.EMFSingleton;
import com.project.entity.Contact;
import com.project.entity.User;

public class ContactDao {
	public boolean saveContact(Contact contact) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		manager.persist(contact);
		transaction.commit();
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
		
	}
	
	public boolean updateContact(Contact contact) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		manager.merge(contact);
		transaction.commit();
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}
	
	public boolean deleteContact(int id) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		Contact contact = manager.find(Contact.class,id);
		manager.remove(contact);
		transaction.commit();
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}
	
	public Contact getContact(int id) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		Contact contact = manager.find(Contact.class, id);
		manager.close();
		return contact;
		
	}
	
	public List<Contact> findAll(){
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		TypedQuery<Contact> query = manager.createQuery("from Contact",Contact.class);
		List<Contact> list = query.getResultList();
		manager.close();
		return list;
	}
	public List<Contact> findByUser(User user){
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		List<Contact> list=null;
		try {
		TypedQuery<Contact> query = manager.createQuery("from Contact c where c.user=?1",Contact.class);
		query.setParameter(1, user);
		list = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
		return list;
	}

}
