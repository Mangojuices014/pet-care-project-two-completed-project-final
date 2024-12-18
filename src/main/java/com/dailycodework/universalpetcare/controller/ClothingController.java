package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.response.ApiResponse;
import com.dailycodework.universalpetcare.service.clothing.IClothingService;
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
@RequiredArgsConstructor
@RequestMapping(UrlMapping.CLOTHING)
public class ClothingController {
    private final IClothingService iClothingService;

    @GetMapping(UrlMapping.GET_ALL_MATERIAL_CLOTHING)
    public ResponseEntity<ApiResponse> getMaterialClothing(){
        try {
            List<String> typeTool = iClothingService.getMaterialClothing();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_COLOR_CLOTHING)
    public ResponseEntity<ApiResponse> getColorClothing(){
        try {
            List<String> typeTool = iClothingService.getColorClothing();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_TARGET_SPECIES)
    public ResponseEntity<ApiResponse> getTargetSpecies(){
        try {
            List<String> typeTool = iClothingService.getTargetSpecies();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_STYLE)
    public ResponseEntity<ApiResponse> getStyle(){
        try {
            List<String> typeTool = iClothingService.getStyle();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }
    
}
