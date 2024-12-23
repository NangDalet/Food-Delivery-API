package com.daletcode.service.impl;

import com.daletcode.dto.DeliveryPartnerRequest;
import com.daletcode.dto.DeliveryPartnerResponse;
import com.daletcode.enumeration.VehicleType;
import com.daletcode.model.DeliveryPartner;
import com.daletcode.repository.DeliveryPartnerRepository;
import com.daletcode.service.DeliveryPartnerService;
import com.daletcode.service.handler.DeliveryPartnerHandlerService;
import com.daletcode.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {

    private final DeliveryPartnerRepository deliveryPartnerRepository;
    private final DeliveryPartnerHandlerService deliveryPartnerHandlerService;
    @Override
    public List<DeliveryPartnerResponse> getList() {
        List<DeliveryPartner> deliveryPartners = deliveryPartnerRepository.findAll();
        if(deliveryPartners.isEmpty()) {
            log.info("Fetch all Delivery Partner not found in DB.");
            return List.of();
        }

        List<DeliveryPartnerResponse> deliveryPartnerResponses = new ArrayList<>();
        for(DeliveryPartner deliveryPartner : deliveryPartners) {

            DeliveryPartnerResponse deliveryPartnerResponse = deliveryPartnerHandlerService
                    .convertDeliveryPartnerToDeliveryPartnerResponse(deliveryPartner);

            deliveryPartnerResponses.add(deliveryPartnerResponse);
        }

        return deliveryPartnerResponses;
    }

    @Override
    public DeliveryPartnerResponse getById(Long id) {
        return null;
    }

    @Override
    public DeliveryPartnerResponse create(DeliveryPartnerRequest deliveryPartnerRequest) {
        DeliveryPartner deliveryPartner = new DeliveryPartner();
        deliveryPartner = deliveryPartnerHandlerService.convertDeliveryPartnerRequestToDeliveryPartner(deliveryPartner, deliveryPartnerRequest);

        log.info("Save new Delivery partner record: {}", deliveryPartner);
        deliveryPartnerRepository.saveAndFlush(deliveryPartner);
        if(deliveryPartner.getId()!=null){
            return deliveryPartnerHandlerService.convertDeliveryPartnerToDeliveryPartnerResponse(deliveryPartner);
        }
        return null;
    }

    @Override
    public DeliveryPartnerResponse update(Long id, DeliveryPartnerRequest deliveryPartnerRequest) {

        Optional<DeliveryPartner> deliveryPartner = deliveryPartnerRepository.findById(id);
        if (deliveryPartner.isEmpty()){
            return new DeliveryPartnerResponse();
        }

        DeliveryPartner updateDeliveryPartner = deliveryPartnerHandlerService.convertDeliveryPartnerRequestToDeliveryPartner(deliveryPartner.get(),deliveryPartnerRequest);
        /*deliveryPartner.get().setFirstName(deliveryPartnerRequest.getFirstName());
        deliveryPartner.get().setLastName(deliveryPartnerRequest.getLastName());
        deliveryPartner.get().setUsername(deliveryPartnerRequest.getUsername());
        deliveryPartner.get().setPassword(deliveryPartnerRequest.getPassword());
        deliveryPartner.get().setGender(deliveryPartnerRequest.getGender());
        deliveryPartner.get().setDateOfBirth(DateTimeUtils.convertStringToDate(deliveryPartnerRequest.getDateOfBirth()));
        deliveryPartner.get().setPhoneNumber(deliveryPartnerRequest.getPhoneNumber());
        deliveryPartner.get().setEmail(deliveryPartnerRequest.getEmail());
        deliveryPartner.get().setAddress(deliveryPartnerRequest.getAddress());
        deliveryPartner.get().setVehicleType(VehicleType.valueOf(deliveryPartnerRequest.getVehicle()));
        deliveryPartner.get().setAvailable(deliveryPartnerRequest.isAvailable());
        deliveryPartner.get().setUpdatedBy("SYSTEM");
        deliveryPartner.get().setUpdateAt(new Date());*/
        updateDeliveryPartner.setUpdatedBy("SYSTEM");
        updateDeliveryPartner.setUpdatedAt(new Date());

        deliveryPartnerRepository.saveAndFlush(updateDeliveryPartner);

        //DeliveryPartner deliveryPartnerUpdate = deliveryPartnerHandlerService.convertDeliveryPartnerRequestToDeliveryPartner(deliveryPartnerRequest);
      /* deliveryPartnerRepository.findById(id).ifPresent(
               deliveryPartner -> {
                   deliveryPartner.setFirstName(deliveryPartnerRequest.getFirstName());
                   deliveryPartner.setLastName(deliveryPartnerRequest.getLastName());
                   deliveryPartner.setUsername(deliveryPartnerRequest.getUsername());
                   deliveryPartner.setPassword(deliveryPartnerRequest.getPassword());
                   deliveryPartner.setGender(deliveryPartnerRequest.getGender());
                   deliveryPartner.setDateOfBirth(DateTimeUtils.convertStringToDate(deliveryPartnerRequest.getDateOfBirth()));
                   deliveryPartner.setPhoneNumber(deliveryPartnerRequest.getPhoneNumber());
                   deliveryPartner.setEmail(deliveryPartnerRequest.getEmail());
                   deliveryPartner.setAddress(deliveryPartnerRequest.getAddress());
                   deliveryPartner.setVehicleType(VehicleType.valueOf(deliveryPartnerRequest.getVehicle()));
                   deliveryPartner.setAvailable(deliveryPartnerRequest.isAvailable());
                   deliveryPartner.setUpdatedBy("SYSTEM");
                   deliveryPartner.setUpdateAt(new Date());

                   log.info("Update Delivery Partner record: {}",deliveryPartner);
                   deliveryPartnerRepository.saveAndFlush(deliveryPartner);
               }
       );*/
       return deliveryPartnerHandlerService.convertDeliveryPartnerToDeliveryPartnerResponse(deliveryPartner.get());
    }

    @Override
    public void delete(Long id) {
        Optional<DeliveryPartner> deliveryPartner = deliveryPartnerRepository.findById(id);
        if (deliveryPartner.isEmpty()){
            log.info("Delivery Partner record not found with id: {}",id);
            return;
        }
        deliveryPartnerRepository.deleteById(id);
    }
}
