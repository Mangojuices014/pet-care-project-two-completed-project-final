package com.dailycodework.universalpetcare.factory.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.Veterinarian;
import com.dailycodework.universalpetcare.model.product.Food;
import com.dailycodework.universalpetcare.repository.FoodRepository;
import com.dailycodework.universalpetcare.request.RegistrationRequest;
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
public class FoodFactory {
    @Autowired
    private final ProductAttributesMapper productAttributesMapper;
    private final FoodRepository foodRepository;

    public Food createFood(ProductDto request, MultipartFile file) throws SQLException, IOException {
        Food food = new Food();
        productAttributesMapper.setCommonAttributes(request, food, file);
        food.setCreatedDate(new Timestamp(new Date().getTime()).toString());
        food.setUpdatedDate(new Timestamp(new Date().getTime()).toString());
        food.setWeight(request.getWeight());
        food.setNutritionFacts(request.getNutritionFacts());
        food.setExpiry(request.getExpiry());
        return foodRepository.save(food);
    }
}
