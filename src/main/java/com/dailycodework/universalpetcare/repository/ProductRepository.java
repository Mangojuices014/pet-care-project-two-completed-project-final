package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
