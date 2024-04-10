package dev.anant.productserviceapplication.controllers;

import dev.anant.productserviceapplication.dtos.ExceptionDto;
import dev.anant.productserviceapplication.dtos.FakeStoreProductDTO;
import dev.anant.productserviceapplication.models.Product;
import dev.anant.productserviceapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// Tell spring this is a special class
// So it automatically create an object of
// it and inject dependencies if needed
// Also this marks that this class has methods
// that need to run if a user sends a request.
@RestController // this annotation is allowing us to do dependency injection.
// the rest controller annotation also tells us that this controller is capable of handling http requests.
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getSingleProduct(@PathVariable("id") Long id){
        //throw new RuntimeException("Something went wrong");
        ResponseEntity<Product> responseEntity = null;
        Product product = null;
        try {
            product = productService.getSingleProduct(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
            System.out.println("Hello");
            return responseEntity;
        } catch (RuntimeException exception) {
            ExceptionDto dto = new ExceptionDto();
            dto.setMessage("Something went wrong");
            ResponseEntity<ExceptionDto> response =
                    new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
            return response;
        }
    }

//    @PostMapping("/products")
//    public FakeStoreProductDTO createProduct(@RequestParam("title") String title, @RequestParam("description") String description){
//        return productService.createProduct(product);
//    }
//    @GetMapping("/products/category/{name}")
//    public List<FakeStoreProductDTO> getProductByCategory(@PathVariable("name") String name){
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
