package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.CategoryDAO;
import com.project.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
 @RequestMapping("/category")
 public String showCategory(Model m)
 {
	 List<Category> listCategories=categoryDAO.listCategories();
	 m.addAttribute("listCategories",listCategories);
	 m.addAttribute("pageinfo","Manage Category");
	 return "Category";
 }
 @RequestMapping(value="/AddCategory",method=RequestMethod.POST)
 public String addCategory(Model m,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc)
 {
	 Category category=new Category();
	 category.setCategoryName(categoryName);
	 category.setCategoryDesc(categoryDesc);
	 categoryDAO.addCategory(category);
	 List<Category> listCategories=categoryDAO.listCategories();
	 m.addAttribute("listCategories",listCategories);
	 m.addAttribute("pageinfo","Manage Category");
	 return "Category";
 }
 
@RequestMapping(value="/deleteCategory/{categoryID}")
public String deleteCategory(Model m,@PathVariable("categoryID")int categoryID)
{
	Category category=categoryDAO.getcategory(categoryID);
	categoryDAO.deleteCategory(category);
	List<Category> listCategories= categoryDAO.listCategories();
	m.addAttribute("listCategories",listCategories);
	 m.addAttribute("pageinfo","Manage Category");
	return "Category";
}

@RequestMapping(value="/editCategory/{categoryID}",method=RequestMethod.POST)
public String editCategory(Model m,@RequestParam("catID")int categoryID,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc)
{
	Category category = categoryDAO.getcategory(categoryID);
	 category.setCategoryName(categoryName);
	 category.setCategoryDesc(categoryDesc);
	 categoryDAO.updateCategory(category);
	m.addAttribute("category",category);
	 m.addAttribute("pageinfo","Manage Category");
	return "UpdateCategory";

}

}
