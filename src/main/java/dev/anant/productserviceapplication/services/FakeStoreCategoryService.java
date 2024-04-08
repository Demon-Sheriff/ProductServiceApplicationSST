package dev.anant.productserviceapplication.services;

import dev.anant.productserviceapplication.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public Category getSingleCategory(Long id) {
        return null;
    }


//    public List<String> getAllCategories(){
//        ArrayList<String> categories = new ArrayList<>();
//        String[] fetchedCategories = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);
//
//        if(fetchedCategories != null){
//            categories.addAll(Arrays.asList(fetchedCategories));
//            return categories;
//        }
//        return null;
//    }
}
