package com.dailycodework.universalpetcare.factory.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.product.Medicine;
import com.dailycodework.universalpetcare.model.product.PetForSale;
import com.dailycodework.universalpetcare.repository.MedicineRepository;
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
public class MedicineFactory {
    private final MedicineRepository medicineRepository;
    @Autowired
    private ProductAttributesMapper productAttributesMapper;

    public Medicine createMedicine(ProductDto request,MultipartFile file) throws SQLException, IOException {
        Medicine medicine = new Medicine();
        productAttributesMapper.setCommonAttributes(request, medicine,file);
        medicine.setCreatedDate(new Timestamp(new Date().getTime()).toString());
        medicine.setUpdatedDate(new Timestamp(new Date().getTime()).toString());
        medicine.setExpirationDate(request.getExpirationDate());
        medicine.setUsageInstruction(request.getUsageInstruction());
        medicine.setTypeMedicine(request.getTypeMedicine());
        return medicineRepository.save(medicine);
    }
}
