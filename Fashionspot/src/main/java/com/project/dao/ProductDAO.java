package com.project.dao;

import java.util.List;

import com.project.model.Product;

public interface ProductDAO 
{
 public boolean addProduct(Product product);
 public boolean deleteProduct(Product product);
 public boolean updateProduct(Product product);
 public List<Product> listProducts();
 public Product getProduct(int productID);
}
