package com.dailycodework.universalpetcare.dto;

import com.dailycodework.universalpetcare.model.product.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class EntityConverter<T, D> {
    private final ModelMapper modelMapper;

    public D mapEntityToDto(T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public T mapDtoToEntity(D dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public ProductDto mapEntityToDtoProduct(Product product, ProductDto dto) {
        // Chuyển đổi tất cả trường tự động
        modelMapper.map(product, dto);

        // Xử lý trường photo riêng
        if (product.getPhoto() != null) {
            try {
                byte[] photoBytes = product.getPhoto().getBytes(1, (int) product.getPhoto().length());
                dto.setPhoto(photoBytes);
            } catch (SQLException e) {
                e.printStackTrace(); // Xử lý ngoại lệ nếu có
            }
        }
        return dto;
    }
}

