package com.dao;

import java.util.List;

import com.dto.Product;
import com.exception.ProductException;

public interface ProductDAO { 
	public String addProduct(Product product) throws ProductException;
	public List<Product> getAllProducts() throws ProductException;
	public List<Product> getAllProductQuantityLessThan(int quantity)throws ProductException;
	public String addProductQuantity(int productId, int Quantity)throws ProductException;
	public String deleteProductByProductName(String pname)throws ProductException;
	public Product getProductByProductName(String pname)throws ProductException;
	public void deleteProductWhoseNameStart(String name)throws ProductException;
}
