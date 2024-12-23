package com.daletcode.service.handler;

import com.daletcode.constant.Constant;
import com.daletcode.dto.DeliveryPartnerRequest;
import com.daletcode.dto.DeliveryPartnerResponse;
import com.daletcode.enumeration.VehicleType;
import com.daletcode.model.DeliveryPartner;
import com.daletcode.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class DeliveryPartnerHandlerService {

    public DeliveryPartner convertDeliveryPartnerRequestToDeliveryPartner(DeliveryPartner deliveryPartner,DeliveryPartnerRequest deliveryPartnerRequest){

        //DeliveryPartner deliveryPartner=new DeliveryPartner();
        deliveryPartner.setFirstName(deliveryPartnerRequest.getFirstName());
        deliveryPartner.setLastName(deliveryPartnerRequest.getLastName());
        deliveryPartner.setUsername(deliveryPartnerRequest.getUsername());
        deliveryPartner.setPassword(deliveryPartnerRequest.getPassword());
        deliveryPartner.setGender(deliveryPartnerRequest.getGender());
        deliveryPartner.setDateOfBirth(DateTimeUtils.convertStringToDate(deliveryPartnerRequest.getDateOfBirth()));
        deliveryPartner.setPhoneNumber(deliveryPartnerRequest.getPhoneNumber());
        deliveryPartner.setVehicleType(VehicleType.valueOf(deliveryPartnerRequest.getVehicle()));
        deliveryPartner.setEmail(deliveryPartner.getEmail());
        deliveryPartner.setAvailable(deliveryPartnerRequest.isAvailable());
        deliveryPartner.setCreatedBy(Constant.SYSTEM);
        deliveryPartner.setCreatedAt(new Date());

        return deliveryPartner;
    }

    public DeliveryPartnerResponse convertDeliveryPartnerToDeliveryPartnerResponse(DeliveryPartner deliveryPartner){

        DeliveryPartnerResponse deliveryPartnerResponse=new DeliveryPartnerResponse();

        deliveryPartnerResponse.setFirstName(deliveryPartner.getFirstName());
        deliveryPartnerResponse.setLastName(deliveryPartner.getLastName());
        deliveryPartnerResponse.setUsername(deliveryPartner.getUsername());
        deliveryPartnerResponse.setPassword(deliveryPartner.getPassword());
        deliveryPartnerResponse.setGender(deliveryPartner.getGender());
        deliveryPartnerResponse.setDateOfBirth(deliveryPartner.getDateOfBirth().toString());
        deliveryPartnerResponse.setPhoneNumber(deliveryPartner.getPhoneNumber());
        deliveryPartnerResponse.setEmail(deliveryPartner.getEmail());
        deliveryPartnerResponse.setAddress(deliveryPartner.getAddress());
        deliveryPartnerResponse.setVehicle(deliveryPartner.getVehicleType().toString());
        deliveryPartnerResponse.setAvailable(deliveryPartner.isAvailable());
        deliveryPartnerResponse.setCreatedBy(deliveryPartner.getCreatedBy());
        deliveryPartnerResponse.setCreatedAt(deliveryPartner.getCreatedAt().toString());
        deliveryPartnerResponse.setUpdatedBy(deliveryPartner.getUpdatedBy());
        deliveryPartnerResponse.setUpdatedAt(deliveryPartner.getUpdatedAt().toString());

        return deliveryPartnerResponse;
    }

}
