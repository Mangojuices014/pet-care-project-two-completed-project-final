package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.product.Medicine;
import com.dailycodework.universalpetcare.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    @Query("SELECT DISTINCT m.typeMedicine FROM Medicine m")
    List<String> findDistinctTypeMedicines();
}
