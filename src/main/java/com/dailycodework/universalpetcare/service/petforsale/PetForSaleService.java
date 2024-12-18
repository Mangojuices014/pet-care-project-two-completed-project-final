package com.dailycodework.universalpetcare.service.petforsale;

import com.dailycodework.universalpetcare.repository.PetForSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetForSaleService implements IPetForSaleService{

    private final PetForSaleRepository petForSaleRepository;

    @Override
    public List<String> getColorPet() {
        return petForSaleRepository.findDistinctColorPets();
    }

    @Override
    public List<String> getBreedColor() {
        return petForSaleRepository.findDistinctBreedColors();
    }
}
