package com.cjc.main.app.serviceimpl;

import java.util.Optional;

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

	@Override
	public Iterable<Product> getProduct() {
		
		return prodrepo.findAll();
	}

	@Override
	public Product updateProduct(int id, Product product) {

	
		Optional<Product> optional = prodrepo.findById(id);
		if(optional.isPresent()) {
		
			Product pro=optional.get();
			product.setPid(pro.getPid());
			
			if(product.getProductname()!=null) {									
				pro.setProductname(product.getProductname());
			}
			if(product.getProductprise()!=null) {									
				pro.setProductprise(product.getProductprise());
			}
			
			return prodrepo.save(product);
			
			
		}
		else {
			
			
			return null;
		}
	}
	
	

	
	
}
