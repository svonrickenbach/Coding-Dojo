package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// returns all the products
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    
//    Find products assigned to a category 
    public List<Product> getAssignedProducts(Category category){
		return productRepository.findAllByCategories(category);
	}
    
//	Find products not assigned to a category 
    public List<Product> getUnassignedProducts(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
    
    // creates a product
    public Product createProduct(Product b) {
        return productRepository.save(b);
    }
    // retrieves a product
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } 
        else {
            return null;
        }	
    }
    // updates a product
    public Product updateProduct(Product product) {
    	return productRepository.save(product); 
    }
    // delete a product
    public void deleteProduct(Long id) {
    	Optional<Product> optionalProduct = productRepository.findById(id);
    	if(optionalProduct.isPresent()) {
    		productRepository.deleteById(id);
    	}
    }   
}