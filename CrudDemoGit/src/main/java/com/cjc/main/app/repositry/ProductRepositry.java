package com.cjc.main.app.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.main.app.model.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer> {

}
