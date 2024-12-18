package com.dailycodework.universalpetcare.factory.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.product.Clothing;
import com.dailycodework.universalpetcare.model.product.PetForSale;
import com.dailycodework.universalpetcare.repository.ClothingRepository;
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
public class ClothingFactory {
    private final ClothingRepository clothingRepository;
    @Autowired
    private ProductAttributesMapper productAttributesMapper;

    public Clothing createClothing(ProductDto request, MultipartFile file) throws SQLException, IOException {
        Clothing clothing = new Clothing();
        productAttributesMapper.setCommonAttributes(request, clothing, file);
        clothing.setCreatedDate(new Timestamp(new Date().getTime()).toString());
        clothing.setUpdatedDate(new Timestamp(new Date().getTime()).toString());
        clothing.setSize(request.getSizeClothing());
        clothing.setColor(request.getColorClothing());
        clothing.setGender(request.getGender());
        clothing.setMaterial(request.getMaterialClothing());
        clothing.setTargetSpecies(request.getTargetSpecies());
        clothing.setStyle(request.getStyle());
        clothing.setSeason(request.getSeason());
        return clothingRepository.save(clothing);
    }
}
