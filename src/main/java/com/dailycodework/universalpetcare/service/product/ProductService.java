package com.dailycodework.universalpetcare.service.product;

import com.dailycodework.universalpetcare.dto.*;
import com.dailycodework.universalpetcare.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    // Lấy các sản phẩm hiển thị lên trang chủ, có trạng thái hiển thị là 1
    public Page<ProductListDto> productList(SearchDto dto);

    // lấy toàn bộ sản phẩm trong csdl
    public List<ProductDto> getAllProduct();

    // lấy thông tin sản phẩm bán chạy
    public Page<ProductTopSale> topSaleProduct(SearchDto dto);

    // lấy thông tin sản phẩm theo id
    public ProductDtoNew getProductById(Long id, String color);

    // lấy thông tin sản phẩm theo id
    public ProductDto getDetailProduct(Long id);

    // Them hoặc cập nhật san pham
    public Product save(ProductDto dto, MultipartFile file) throws SQLException, IOException;

    public ProductDto update(Long productId,ProductDto dto);

    // xoá mềm sản phẩm
    public Boolean delete(Long id);


}
