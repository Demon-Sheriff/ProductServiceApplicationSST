package dev.anant.productserviceapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private String description;
    private String Category;
    private String image;
    private  double price;
}
