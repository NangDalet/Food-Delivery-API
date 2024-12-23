package com.daletcode.service;

import com.daletcode.dto.PaymentRequest;

public interface PaymentService {

    String pay(PaymentRequest paymentRequest);

    String inquiry(String orderId);
}
