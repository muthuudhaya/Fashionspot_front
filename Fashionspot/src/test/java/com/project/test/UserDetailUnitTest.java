package com.project.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.dao.UserDetailDAO;
import com.project.model.UserDetail;

public class UserDetailUnitTest {
	static UserDetailDAO userdetailDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		 context.scan("com.project");
	     context.refresh();
	     userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}    
    @Ignore
	@Test
	public void addusertest() 
	{
		UserDetail user = new UserDetail();
		user.setCustomername("Vighnesh");
		user.setCustomerAddr("Delhi");
		user.setUsername("vicky");
		user.setPassword("vicky");
		user.setRole("User");
		user.setEnabled(true);
		assertTrue("Problem in adding User Details",userdetailDAO.registerUser(user));
	}
    @Test
    public void updateusertest()
    {
    	UserDetail user = userdetailDAO.getUser("vicky");
    	user.setCustomerAddr("Delhi Kingsway");
		assertTrue("Problem in updating User Details",userdetailDAO.updateAddress(user));
	}
    @Test
    public void viewusertest()
    {
    	UserDetail user = userdetailDAO.getUser("muthu");

    	System.out.println("Customer name           :"+user.getCustomername());
    	System.out.println("Customer Address        :"+user.getCustomerAddr());
    	System.out.println("Customer Role           :"+user.getRole());
    	System.out.println("Customer Account Status :"+user.isEnabled());
       
    }
}
