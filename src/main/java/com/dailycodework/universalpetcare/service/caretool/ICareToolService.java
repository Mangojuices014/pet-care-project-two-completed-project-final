package com.dailycodework.universalpetcare.service.caretool;

import com.dailycodework.universalpetcare.model.Veterinarian;
import com.dailycodework.universalpetcare.model.product.Tool;

import java.util.List;

public interface ICareToolService {
    List<String> getTypeTools();
    List<String> getSizes();
    List<String> getMaterials();

}
