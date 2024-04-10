package dev.anant.productserviceapplication.services;

import dev.anant.productserviceapplication.dtos.FakeStoreProductDTO;
import dev.anant.productserviceapplication.models.Category;
import dev.anant.productserviceapplication.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate = new RestTemplate(); // rest Template is a class provided by spring for making http requests.


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOs = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class
        );

        if(fakeStoreProductDTOs != null){
            List<Product> allProducts = new ArrayList<>();

            for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOs){
                Product curr_Product = convertToProduct(fakeStoreProductDTO);
                allProducts.add(curr_Product);
            }
            return allProducts;
        }
        return null;
    }

    private Product convertToProduct(FakeStoreProductDTO fakeStoreProductDto) {
        if(fakeStoreProductDto == null) return null;

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        product.setImageUrl(fakeStoreProductDto.getImage());

        return product;
    }

    private FakeStoreProductDTO convertToFakeStoreProductDTO(Product product){
        if(product == null) return null;

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setImage(product.getImageUrl());

        return fakeStoreProductDTO;
    }

    @Override
    public Product getSingleProduct(Long id){
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class
        );

        return convertToProduct(fakeStoreProductDTO);
    }

    // add new Product
    @Override
    public Product createProduct(Product product){
        FakeStoreProductDTO fakeStoreProductDTO = convertToFakeStoreProductDTO(product);

        FakeStoreProductDTO fakeStoreProductDtoOutput = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDTO,
                FakeStoreProductDTO.class
        );

        return convertToProduct(fakeStoreProductDtoOutput);
    }

    // update a product
    @Override
    public void updateProduct(Product product, Long id){
        FakeStoreProductDTO fakeStoreProductDTO = convertToFakeStoreProductDTO(product);

        restTemplate.put(
                "https://fakestoreapi.com/products/" + id,
                fakeStoreProductDTO,
                FakeStoreProductDTO.class
        );
    }


    //public Product getSingleProduct(Long id) {
//        // the get for object expects the url of the api as one parameter
//        // the other parameter will be the dto class for the current class
//        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
//        Product product = new Product();
//        product.setId(fakeStoreProductDTO.getId());
//        product.setTitle(fakeStoreProductDTO.getTitle());
//        product.setPrice(fakeStoreProductDTO.getPrice());
//        product.setImageUrl(fakeStoreProductDTO.getImage());
//        product.setDescription(fakeStoreProductDTO.getDescription());
//        product.setCategory(new Category());
//
//        return product;
//    }


//    @Override
//    public Product createProduct(Product product) {
////        //restTemplate.postForObject();
////        FakeStoreProductDTO fakeStoreProductDto = convertToFakeStoreProductDto(product);
////
////        FakeStoreProductDTO fakeStoreProductDtoOutput = restTemplate.postForObject(
////                "https://fakestoreapi.com/products",
////                fakeStoreProductDto,
////                FakeStoreProductDTO.class
////        );
////
////        return convertToProduct(fakeStoreProductDtoOutput);
//        return null;
//    }

    @Override
    public List<Product> getProductCategory(String category) {
        return null;
    }

    // delete a product
    @Override
    public void deleteProduct(Long id){
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }
}
