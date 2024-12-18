package com.dailycodework.universalpetcare.service.clothing;

import java.util.List;

public interface IClothingService {
    List<String> getMaterialClothing();
    List<String> getTargetSpecies();
    List<String> getColorClothing();
    List<String> getStyle();
}
