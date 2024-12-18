package com.dailycodework.universalpetcare.service.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.model.product.Product;
import com.dailycodework.universalpetcare.request.RegistrationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Component
public class ProductAttributesMapper {
    public void setCommonAttributes(ProductDto source, Product target, MultipartFile file) throws IOException, SQLException {
        target.setType(source.getType());
        target.setName(source.getName());
        target.setSku(source.getSku());
        target.setSlug(source.getSlug());
        target.setDescription(source.getDescription());
        target.setPrice(source.getPrice());
        target.setDisplay(1);
        // Kiểm tra nếu có ảnh được gửi lên
        if (file != null && !file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes); // Chuyển ảnh thành Blob
            target.setPhoto(photoBlob);
        }
    }
}

