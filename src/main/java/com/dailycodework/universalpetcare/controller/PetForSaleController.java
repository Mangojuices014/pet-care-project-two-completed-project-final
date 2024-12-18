package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.response.ApiResponse;
import com.dailycodework.universalpetcare.service.petforsale.IPetForSaleService;
import com.dailycodework.universalpetcare.utils.FeedBackMessage;
import com.dailycodework.universalpetcare.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping(UrlMapping.PET_FOR_SALE)
@RequiredArgsConstructor
public class PetForSaleController {

    private final IPetForSaleService iPetForSaleService;

    @GetMapping(UrlMapping.GET_ALL_COLOR_PET)
    public ResponseEntity<ApiResponse> getColorPet(){
        try {
            List<String> typeTool = iPetForSaleService.getColorPet();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_BREED_PET)
    public ResponseEntity<ApiResponse> getBreedColor(){
        try {
            List<String> typeTool = iPetForSaleService.getBreedColor();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
