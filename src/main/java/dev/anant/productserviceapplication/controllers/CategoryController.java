package dev.anant.productserviceapplication.controllers;

import dev.anant.productserviceapplication.models.Product;
import dev.anant.productserviceapplication.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CategoryController {

    private CategoryService categoryService;
//    @GetMapping("products/categories")
//    public List<String> getAllCategories(){
//        return categoryService.getAllCategories();
//    }

    @GetMapping("/{category}/product")
    // get products in a specific category
    public Product getProductinCategory(@PathVariable("category") String category){
        return new Product();
    }


}