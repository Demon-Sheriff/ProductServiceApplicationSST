package dev.anant.productserviceapplication.services;

import dev.anant.productserviceapplication.dtos.FakeStoreProductDTO;
import dev.anant.productserviceapplication.models.Product;

import java.util.*;

public interface ProductService {

    List<Product> getAllProducts();
    Product getSingleProduct(Long id);
    Product createProduct(Product product);
    List<Product> getProductCategory(String category);
    void deleteProduct(Long id);
    void updateProduct(Product product, Long id);
}
