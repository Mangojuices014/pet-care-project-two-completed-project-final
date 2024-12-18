package com.dailycodework.universalpetcare.service.material;

import com.dailycodework.universalpetcare.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService implements IMedicineService{

    private final MedicineRepository medicineRepository;

    @Override
    public List<String> getTypeTools() {
        return medicineRepository.findDistinctTypeMedicines();
    }
}
