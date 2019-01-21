package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.UserDetail;
@Repository("userdetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {
    @Autowired
    SessionFactory sessionFactory;
	@Override
	public boolean registerUser(UserDetail user) {
		try 
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean updateAddress(UserDetail user) {
		try 
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public UserDetail getUser(String username) {
		Session session = sessionFactory.openSession();
		UserDetail user = session.get(UserDetail.class,username);
		return user;
	}
    
}
