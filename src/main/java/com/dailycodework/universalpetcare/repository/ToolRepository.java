package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.product.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Long> {

    @Query("SELECT DISTINCT t.typeTool FROM Tool t")
    List<String> findDistinctTypeTools();

    @Query("SELECT DISTINCT t.size FROM Tool t")
    List<String> findDistinctSizes();


    @Query("SELECT DISTINCT t.material FROM Tool t")
    List<String> findDistinctMaterials();



}
