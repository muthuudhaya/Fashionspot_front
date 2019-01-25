package com.project.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.CategoryDAO;
import com.project.dao.ProductDAO;
import com.project.model.Category;
import com.project.model.Product;

@Controller
public class ProductController 
{
 @Autowired
 CategoryDAO categoryDAO;
 
 @Autowired
 ProductDAO productDAO;
 
 @RequestMapping("/product")
 public String showProduct(Model m)
 {
	Product product = new Product();
	m.addAttribute(product);
	List<Product> listProducts=productDAO.listProducts();
	m.addAttribute("productList",listProducts);
	m.addAttribute("categoryList", this.GetCategories());
	m.addAttribute("pageinfo","Manage Product");
	  return "product";
 }
@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
public String insertProduct(@ModelAttribute("product")Product product,Model m)
{
	productDAO.addProduct(product);
	Product product1=new Product();
	m.addAttribute(product1);
	m.addAttribute("categoryList", this.GetCategories());
	List<Product> listProducts=productDAO.listProducts();
	m.addAttribute("productList",listProducts);
	m.addAttribute("pageinfo","Manage Product");
	  return "product";

}
public LinkedHashMap<Integer,String> GetCategories()
{
	 List<Category> listCategories=categoryDAO.listCategories();
     LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
     for(Category category:listCategories)
     {
    	 categoryList.put(category.getCategoryID(),category.getCategoryName());
     }
     return categoryList;
}

 
 
 
}
