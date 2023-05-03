package com.cjc.main.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.app.model.Product;
import com.cjc.main.app.response.BaseResponse;
import com.cjc.main.app.servicei.ProductService;

@RestController

public class Controller {
	
	@Autowired
	ProductService proservice;
	Date date=new Date();
	@PostMapping("/addproduct")
	public ResponseEntity<BaseResponse<Product>> addproduct(@RequestBody Product product)
	{
		Product pro=proservice.saveProduct(product);
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(200, date,"Data Is AddedSucess fully", pro);
		ResponseEntity<BaseResponse<Product>> entity=new ResponseEntity<BaseResponse<Product>>(baseResponse,HttpStatus.OK);
			
		return entity;
		
	}
	
	@GetMapping("/getproduct")
	public ResponseEntity<BaseResponse<Iterable<Product>>> getPRoduct()
	{
		Iterable<Product> iterable=proservice.getProduct();
		BaseResponse<Iterable<Product>> baseResponse=new BaseResponse<Iterable<Product>>(200, date, "data is get Sucessfull", iterable);
		ResponseEntity<BaseResponse<Iterable<Product>>> entity=new ResponseEntity<BaseResponse<Iterable<Product>>>(baseResponse, HttpStatus.OK);
		return entity;
		
		
	}
	
	
	@PutMapping("/update/{pid}")
	public ResponseEntity<BaseResponse<Product>> updateproduct(@PathVariable int pid,@RequestBody Product product)
	{
		Product pro=proservice.updateProduct(pid,product);
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(200, date, "Data Is Get From Database", pro);
		ResponseEntity<BaseResponse<Product>> entity=new ResponseEntity<BaseResponse<Product>>(baseResponse, HttpStatus.OK);
		return entity;
		
	}
	
	
	
	

}
