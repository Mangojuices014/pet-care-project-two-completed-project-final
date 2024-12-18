package com.dailycodework.universalpetcare.factory.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.product.Food;
import com.dailycodework.universalpetcare.model.product.PetForSale;
import com.dailycodework.universalpetcare.repository.PetForSaleRepository;
import com.dailycodework.universalpetcare.service.product.ProductAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PetFactory {

    private final PetForSaleRepository petForSaleRepository;
    @Autowired
    private final ProductAttributesMapper productAttributesMapper;

    public PetForSale createPet(ProductDto request, MultipartFile file) throws SQLException, IOException {
        PetForSale pet = new PetForSale();
        productAttributesMapper.setCommonAttributes(request, pet, file);
        pet.setCreatedDate(new Timestamp(new Date().getTime()).toString());
        pet.setUpdatedDate(new Timestamp(new Date().getTime()).toString());
        pet.setFullName(request.getFullName());
        pet.setAge(request.getAge());
        pet.setBreed(request.getBreedColor());
        pet.setColor(request.getColorPet());
        pet.setHealthStatus(request.getHealthStatus());
        return petForSaleRepository.save(pet);
    }

}
