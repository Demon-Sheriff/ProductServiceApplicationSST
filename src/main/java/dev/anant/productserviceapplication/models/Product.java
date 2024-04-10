package dev.anant.productserviceapplication.models;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    private Long id;
    private String title;
    private String description;
    private double Price;
    private Category category;
    private String imageUrl;
}