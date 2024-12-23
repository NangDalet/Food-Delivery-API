package com.daletcode.controller;

import com.daletcode.dto.OrderRequest;
import com.daletcode.dto.OrderStatusRequest;
import com.daletcode.exception.ApiResponseUtil;
import com.daletcode.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping(value = "v1/orders", consumes = "application/json", produces = "application/json")
    private ResponseEntity<Object> create(@RequestBody OrderRequest orderRequest) {
        log.info("Intercept request create new order v1 with request: {}", orderRequest);

        return new ResponseEntity<>(ApiResponseUtil.successResponse(orderService.create(orderRequest)), HttpStatus.OK);
    }

    @PutMapping(value = "v1/orders", consumes = "application/json", produces = "application/json")
    private ResponseEntity<Object> update(@RequestBody OrderStatusRequest orderStatusRequest) {
        log.info("Intercept request update order status v1 with request: {}", orderStatusRequest);

        return new ResponseEntity<>(ApiResponseUtil.successResponse(orderService.update(orderStatusRequest)), HttpStatus.OK);
    }
}

