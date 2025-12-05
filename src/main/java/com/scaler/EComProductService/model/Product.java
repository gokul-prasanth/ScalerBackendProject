package com.scaler.EComProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity
public class Product  extends BaseModel {

    private String title;
    private String description;
    private String image;
    @OneToOne
    private Price price;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Orders> orderList;

}