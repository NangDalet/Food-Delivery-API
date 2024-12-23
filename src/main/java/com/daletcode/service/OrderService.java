package com.daletcode.service;

import com.daletcode.dto.OrderRequest;
import com.daletcode.dto.OrderResponse;
import com.daletcode.dto.OrderStatusRequest;

public interface OrderService {

    OrderResponse create(OrderRequest orderRequest);

    OrderResponse update(OrderStatusRequest orderStatusRequest);

}
