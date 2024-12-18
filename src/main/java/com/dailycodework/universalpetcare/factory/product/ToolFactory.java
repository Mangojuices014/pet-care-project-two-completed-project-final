package com.dailycodework.universalpetcare.factory.product;

import com.dailycodework.universalpetcare.dto.ProductDto;
import com.dailycodework.universalpetcare.model.product.Tool;
import com.dailycodework.universalpetcare.repository.ToolRepository;
import com.dailycodework.universalpetcare.service.product.ProductAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ToolFactory {
    private final ToolRepository careToolsRepository;
    @Autowired
    private ProductAttributesMapper productAttributesMapper;

    public Tool createCareTool(ProductDto request, MultipartFile file) throws SQLException, IOException {
        Tool careTools = new Tool();
        productAttributesMapper.setCommonAttributes(request, careTools, file);
        careTools.setCreatedDate(new Timestamp(new Date().getTime()).toString());
        careTools.setUpdatedDate(new Timestamp(new Date().getTime()).toString());
        careTools.setTypeTool(request.getTypeCareTools());
        careTools.setMaterial(request.getMaterialCareTool());
        careTools.setSize(request.getSizeCareTool());
        return careToolsRepository.save(careTools);
    }
}
