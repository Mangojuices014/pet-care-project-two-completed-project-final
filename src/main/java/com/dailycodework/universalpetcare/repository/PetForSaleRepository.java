package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.product.PetForSale;
import com.dailycodework.universalpetcare.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetForSaleRepository extends JpaRepository<PetForSale, Long> {
    @Query("SELECT DISTINCT p.color FROM PetForSale p")
    List<String> findDistinctColorPets();

    @Query("SELECT DISTINCT p.breed FROM PetForSale p")
    List<String> findDistinctBreedColors();
}
