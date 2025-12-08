package com.scaler.EComProductService.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {

    public UUID id;
    public String title;
    public  double price;
    public String category;
    public String description;
    public String image;
}
