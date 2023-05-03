package com.cjc.main.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.app.model.Product;
import com.cjc.main.app.repositry.ProductRepositry;
import com.cjc.main.app.servicei.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepositry prodrepo;

	@Override
	public Product saveProduct(Product product) {
		
		return prodrepo.save(product);
	}
	
	

	
	
}
