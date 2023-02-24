package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;


@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	// returns all the categories
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
    // creates a category
    public Category createCategory(Category b) {
        return categoryRepository.save(b);
    }
    
//    Find categories assigned to a product
    public List<Category> getAssignedCategories(Product product){
		return categoryRepository.findAllByProducts(product);
	}
    
//    Find categories that are not assigned to a product
    public List<Category> getUnassignedCategories(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
    
    // retrieves a category
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } 
        else {
            return null;
        }	
    }
    // updates a category
    public Category updateCategory(Category category) {
    	return categoryRepository.save(category); 
    }
    // delete a category
    public void deleteCategory(Long id) {
    	Optional<Category> optionalCategory = categoryRepository.findById(id);
    	if(optionalCategory.isPresent()) {
    		categoryRepository.deleteById(id);
    	}
    }   
}