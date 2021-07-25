package com.example.product.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		productRepository.save(product);
		System.out.println("Product added successfully::"+product.getId());
		return product;
	}
	
	@GetMapping("/list")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/findProduct/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productRepository.findById(id);
	}
	
	@GetMapping
	public Optional<Product> getProduct(@RequestBody Product product) {
		return productRepository.findById(product.getId());
	}
	
	@DeleteMapping
	public String deleteProduct(@RequestBody Product product) {
		long id = product.getId();
		productRepository.deleteById(id);
		return "Deleted Product Successfully::"+id;
	}
	

}
