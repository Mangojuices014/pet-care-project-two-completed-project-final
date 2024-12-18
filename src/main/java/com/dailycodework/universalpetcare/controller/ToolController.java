package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.response.ApiResponse;
import com.dailycodework.universalpetcare.service.caretool.ICareToolService;
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
@RequestMapping(UrlMapping.TOOL)
@RequiredArgsConstructor
public class ToolController {
    private final ICareToolService iCareToolService;

    @GetMapping(UrlMapping.GET_ALL_TYPE_TOOL)
    public ResponseEntity<ApiResponse> getTypeTool(){
        try {
            List<String> typeTool = iCareToolService.getTypeTools();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_SIZE)
    public ResponseEntity<ApiResponse> getSizes(){
        try {
            List<String> typeTool = iCareToolService.getSizes();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_MATERIAL_TOOL)
    public ResponseEntity<ApiResponse> getMaterials(){
        try {
            List<String> typeTool = iCareToolService.getMaterials();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.RESOURCE_FOUND, typeTool));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
