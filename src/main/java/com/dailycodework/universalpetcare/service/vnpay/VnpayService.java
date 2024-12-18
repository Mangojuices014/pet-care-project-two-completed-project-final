package com.dailycodework.universalpetcare.service.vnpay;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface VnpayService {
    String createOrder(int total, String reason, String urlReturn, String ipAddr);

    int orderReturn(HttpServletRequest request);
}
