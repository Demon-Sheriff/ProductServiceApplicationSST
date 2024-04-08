package dev.anant.productserviceapplication.controllers;

import dev.anant.productserviceapplication.models.Product;
import dev.anant.productserviceapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// Tell spring this is a special class
// So it automatically create an object of
// it and inject dependencies if needed
// Also this marks that this class has methods
// that need to run if a user sends a request.
@RestController // this annotation is allowing us to do dependency injection.
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    // Whenever anyone sends a
    // GET request as {MY_SERVER}/hello url
    // run this method and return whatever
    // this is returning to the client

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }


//    @PostMapping("/products")
//    public Product createProduct(@RequestParam("title") String title, @RequestParam("description") String description){
//        return productService.createProduct(product);
//    }
//    @GetMapping("/products/category/{name}")
//    public List<Product> getProductByCategory(@PathVariable("name") String name){
//
//        return productService.getProductByCategory(name);
//    }

    // add new product (check this)
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
        productService.updateProduct(product,id);
    }
}
