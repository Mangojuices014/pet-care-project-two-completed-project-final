package com.dailycodework.universalpetcare.service.product;

import com.dailycodework.universalpetcare.dto.*;
import com.dailycodework.universalpetcare.factory.product.ProductFactory;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.model.product.Product;
import com.dailycodework.universalpetcare.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService{

    private final ProductRepository productRepository;
    private final ProductFactory productFactory;
    private final EntityConverter<Product, ProductDto> entityConverter;

    @Override
    public Product save(ProductDto dto, MultipartFile file) throws SQLException, IOException {
        return productFactory.addProduct(dto, file);
    }
    @Override
    public Page<ProductListDto> productList(SearchDto dto) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> {
                    ProductDto dto = new ProductDto(); // Khởi tạo DTO
                    return entityConverter.mapEntityToDtoProduct(product, dto); // Sử dụng phương thức mapEntityToDtoProduct
                })
                .collect(Collectors.toList());
    }
    @Override
    public Page<ProductTopSale> topSaleProduct(SearchDto dto) {
        return null;
    }

    @Override
    public ProductDtoNew getProductById(Long id, String color) {
        return null;
    }

    @Override
    public ProductDto getDetailProduct(Long id) {
        return null;
    }

    @Override
    public ProductDto update(Long productId,ProductDto dto) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
