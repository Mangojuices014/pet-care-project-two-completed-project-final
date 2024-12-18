package com.dailycodework.universalpetcare.service.caretool;

import com.dailycodework.universalpetcare.model.product.Tool;
import com.dailycodework.universalpetcare.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareToolService implements ICareToolService{
    private final ToolRepository toolRepository;
    @Override
    public List<String> getTypeTools() {
        return toolRepository.findDistinctTypeTools();
    }

    @Override
    public List<String> getSizes() {
        return toolRepository.findDistinctSizes();
    }

    @Override
    public List<String> getMaterials() {
        return toolRepository.findDistinctMaterials();
    }
}
