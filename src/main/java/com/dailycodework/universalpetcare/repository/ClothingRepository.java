package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.product.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClothingRepository extends JpaRepository<Clothing, Long> {
    @Query("SELECT DISTINCT c.material FROM Clothing c")
    List<String> findMaterialClothing();


    @Query("SELECT DISTINCT c.targetSpecies FROM Clothing c")
    List<String> findDistinctTargetSpecies();

    @Query("SELECT DISTINCT c.color FROM Clothing c")
    List<String> findDistinctColorClothing();


    @Query("SELECT DISTINCT c.style FROM Clothing c")
    List<String> findDistinctStyle();

}
