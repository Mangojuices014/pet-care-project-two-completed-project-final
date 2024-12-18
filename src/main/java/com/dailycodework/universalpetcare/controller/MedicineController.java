package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.response.ApiResponse;
import com.dailycodework.universalpetcare.service.material.IMedicineService;
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
@RequestMapping(UrlMapping.MEDICINE)
public class MedicineController {
    private final IMedicineService iMedicineService;

    @GetMapping(UrlMapping.GET_ALL_TYPE_MEDICINE)
    public ResponseEntity<ApiResponse> getTypeTools(){
        try {
            List<String> typeTool = iMedicineService.getTypeTools();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
