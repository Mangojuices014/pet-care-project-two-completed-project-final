package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.product.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
