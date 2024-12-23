package com.daletcode.service;

import com.daletcode.dto.DeliveryPartnerRequest;
import com.daletcode.dto.DeliveryPartnerResponse;

import java.util.List;

public interface DeliveryPartnerService {
    List<DeliveryPartnerResponse> getList();
    DeliveryPartnerResponse getById(Long id);
    DeliveryPartnerResponse create(DeliveryPartnerRequest deliveryPartnerRequest);
    DeliveryPartnerResponse update(Long id,DeliveryPartnerRequest deliveryPartnerRequest);
    void delete(Long id);

}
