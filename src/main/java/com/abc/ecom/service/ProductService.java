package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Product;

public interface ProductService {
	public void saveProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(int productId);

	public Product updateProduct(Product product);

	public void deleteProduct(int productId);

	public Product getProductByName(String productName);

	public List<Product> getProductsByCategory(String category);
}
