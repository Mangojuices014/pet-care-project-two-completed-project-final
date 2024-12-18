package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.model.payment.CreateVNPAYModel;
import com.dailycodework.universalpetcare.service.vnpay.VnpayService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/vnpay")
@RequiredArgsConstructor
public class VnpayPaymentController {

    @Autowired
    private VnpayService vnPayService;

    @PostMapping(value = "/submitOrder", produces = "application/json;charset=UTF-8")
    public String submitOrder(@RequestBody CreateVNPAYModel createVNPAYModel,
                              HttpServletRequest request) {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return vnPayService.createOrder(createVNPAYModel.getAmount(), createVNPAYModel.getReason(), baseUrl, request.getRemoteAddr());
    }


}
