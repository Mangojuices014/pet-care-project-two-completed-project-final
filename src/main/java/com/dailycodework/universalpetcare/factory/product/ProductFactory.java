package com.dailycodework.universalpetcare.factory.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.model.product.Product;
import com.dailycodework.universalpetcare.request.RegistrationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductFactory {
    public Product addProduct(ProductDto productDto, MultipartFile file) throws SQLException, IOException;
}
