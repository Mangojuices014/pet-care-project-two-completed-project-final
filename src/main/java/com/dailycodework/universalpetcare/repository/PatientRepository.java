package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<com.dailycodework.universalpetcare.model.Patient, Long> {
}
