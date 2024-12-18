package com.dailycodework.universalpetcare.factory.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.product.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class SimpleProductFactory implements ProductFactory{
    private final FoodFactory food;
    private final MedicineFactory medicine;
    private final ToolFactory careTools;
    private final PetFactory petForSale;
    private final ClothingFactory clothingFactory;

    @Override
    public Product addProduct(ProductDto productDto, MultipartFile file) throws SQLException, IOException {
        switch (productDto.getType()) {
            case FOOD: {
                return food.createFood(productDto, file);
            }
            case PET: {
                return petForSale.createPet(productDto, file);
            }
            case MEDICINE: {
                return medicine.createMedicine(productDto, file);
            }
            case TOOL: {
                return careTools.createCareTool(productDto, file);
            }
            case CLOTHING: {
                return clothingFactory.createClothing(productDto, file);
            }
            default: {
                return null;
            }
        }
    }

}
