package com.dailycodework.universalpetcare.service.clothing;

import com.dailycodework.universalpetcare.repository.ClothingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothingService implements IClothingService{
    private final ClothingRepository clothingRepository;
    @Override
    public List<String> getMaterialClothing() {
        return clothingRepository.findMaterialClothing();
    }

    @Override
    public List<String> getTargetSpecies() {
        return clothingRepository.findDistinctTargetSpecies();
    }

    @Override
    public List<String> getColorClothing() {
        return clothingRepository.findDistinctColorClothing();
    }

    @Override
    public List<String> getStyle() {
        return clothingRepository.findDistinctStyle();
    }
}
