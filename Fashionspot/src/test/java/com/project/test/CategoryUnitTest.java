package com.project.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.dao.CategoryDAO;
import com.project.model.Category;

public class CategoryUnitTest 
{
    
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	     context.scan("com.project");
	     context.refresh();
	     categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	     
	}
	@Ignore
	@Test
	public void addCategoryTest() 
	{
		Category category = new Category();
		category.setCategoryName("Shirt");
		category.setCategoryDesc("Full Sleve");
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
	}
	@Ignore
    @Test
    public void deleteCategoryTest()
    {
    	Category category=categoryDAO.getcategory(1);
    	assertTrue("Problem in deleting Category",categoryDAO.deleteCategory(category));
    }
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories = categoryDAO.listCategories();
		assertTrue("Problem in Listing Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println("Category ID : " +category.getCategoryID());
			System.out.println("Category Name : " +category.getCategoryName());
			System.out.println("Category Description : " +category.getCategoryDesc());
		}
		
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getcategory(2);
		category.setCategoryName("T-Shirt");
		category.setCategoryDesc("Sports");
    	assertTrue("Problem in updating Category",categoryDAO.updateCategory(category));

	}
}
