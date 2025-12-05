package com.scaler.EComProductService.repository;


import com.scaler.EComProductService.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
