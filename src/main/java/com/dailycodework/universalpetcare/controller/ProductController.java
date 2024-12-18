package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.dto.EntityConverter;
import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.dto.UserDto;
import com.dailycodework.universalpetcare.exception.AlreadyExistsException;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.model.product.Product;
import com.dailycodework.universalpetcare.request.RegistrationRequest;
import com.dailycodework.universalpetcare.response.ApiResponse;
import com.dailycodework.universalpetcare.service.product.ProductService;
import com.dailycodework.universalpetcare.utils.FeedBackMessage;
import com.dailycodework.universalpetcare.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(UrlMapping.PRODUCTS)
public class ProductController {

    private final ProductService productService;
    private final EntityConverter<Product, ProductDto> entityConverter;

    @PostMapping(UrlMapping.ADD_PRODUCT)
    public ResponseEntity<ApiResponse> addProduct(@RequestParam("file") MultipartFile file ,
                                                  @ModelAttribute ProductDto request){
        try {
            Product theProduct = productService.save(request, file);
            ProductDto registeredUser = entityConverter.mapEntityToDto(theProduct, ProductDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.CREATE_PRODUCT_SUCCESS, registeredUser));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_PRODUCTS)
    public ResponseEntity<ApiResponse> getAllProduct(){
        List<ProductDto> theProducts = productService.getAllProduct();
        return ResponseEntity.status(OK).body(new ApiResponse(FeedBackMessage.PRODUCT_FOUND, theProducts));
    }

}
