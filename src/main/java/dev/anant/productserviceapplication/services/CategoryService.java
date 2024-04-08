package dev.anant.productserviceapplication.services;

import dev.anant.productserviceapplication.models.Category;

import java.util.List;

public interface CategoryService {
    List<String> getAllCategories();
    Category getSingleCategory(Long id);
//    InterfaceType createCategory(InterfaceType category);
//    void deleteCategory(Long id);
//    void updateCategory(InterfaceType category, Long id);
}
