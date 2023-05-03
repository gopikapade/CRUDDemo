package com.cjc.main.app.servicei;

import com.cjc.main.app.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public Iterable<Product> getProduct();

	public Product updateProduct(int id, Product product);

}
