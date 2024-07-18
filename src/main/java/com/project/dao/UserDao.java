package com.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.config.EMFSingleton;
import com.project.entity.User;

public class UserDao {
	public boolean saveUser(User user) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		manager.persist(user);
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
	public boolean updateUser(User user) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		manager.merge(user);
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
	
	public boolean deleteUser(int id) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		User user = manager.find(User.class, id);
		manager.remove(user);
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
	
	public User getUser(int id) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		User user = manager.find(User.class, id);
		manager.close();
		
		return user;

	}
	public User findByEmailAndPassword(String email,String Password) {
		EntityManager manager=EMFSingleton.getFactory().createEntityManager();
		User user=null;
		try {
			TypedQuery<User> query = manager.createQuery("from User u where u.email=?1 and u.password=?2",User.class);
			query.setParameter(1, email);
			query.setParameter(2, Password);
		    user= query.getSingleResult();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		finally {
			manager.close();
			
		}
		return user;
	}

}
