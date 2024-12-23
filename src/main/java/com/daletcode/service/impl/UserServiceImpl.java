package com.daletcode.service.impl;

import com.daletcode.dto.UserRequest;
import com.daletcode.dto.UserResponse;
import com.daletcode.model.Device;
import com.daletcode.model.User;
import com.daletcode.repository.DeviceRepository;
import com.daletcode.repository.UserRepository;
import com.daletcode.service.UserService;
import com.daletcode.service.handler.UserHandlerService;
import com.daletcode.utils.DateTimeUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final DeviceRepository deviceRepository;

    private final UserHandlerService userHandlerService;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, DeviceRepository deviceRepository, UserHandlerService userHandlerService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.deviceRepository = deviceRepository;
        this.userHandlerService = userHandlerService;
    }

    @Override
    public List<UserResponse> findAll() {
       List<User> users = userRepository.findAll();

       List<UserResponse> userResponses = new ArrayList<>();
       for(User user: users){
           UserResponse userResponse = userHandlerService.convertUserToUserResponse(user);
           userResponses.add(userResponse);
       }
       return userResponses;
    }

    @Override
    public UserResponse findById(Long id) {
       Optional<User> user = userRepository.findById(id);
       if(user.isEmpty()){
           log.info("User with id {} not found in DB.", id);
           return new UserResponse();
       }
       return userHandlerService.convertUserToUserResponse(user.get());
    }

    @Transactional
    @Override
    public UserResponse create(UserRequest userRequest) {

       userHandlerService.usernameHasText(userRequest.getUsername());
       userHandlerService.phoneNumberHasText(userRequest.getPhoneNumber());

        User user = userHandlerService.convertUserToUserRequest(userRequest);

        log.info("Save user record: {}", user);
        userRepository.saveAndFlush(user);

        if(user.getId()!=null){
            Device device = userHandlerService.convertDeviceRequestToUserDevice(user, userRequest.getDeviceRequest());
            log.info("Save device record: {}", device);
           /* device.setDeviceId(deviceRequest.getDeviceId());
            device.setDeviceModel(deviceRequest.getDeviceModel());
            device.setDeviceType(deviceRequest.getDeviceType());
            device.setOsVersion(deviceRequest.getOsVersion());
            device.setAppVersion(deviceRequest.getAppVersion());
            device.setTrustDevice(deviceRequest.isTrustDevice());
            device.setUser(user);*/
            deviceRepository.save(device);
        }

        return null;
    }
@Transactional
    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            log.info("User update with id {} not found in DB.", id);
            this.create(userRequest);
            return null;
        }
        //User userUpdate = user.get();
        //userUpdate.setUsername(userRequest.getUsername());
        user.get().setUsername(userRequest.getUsername());
        user.get().setPhoneNumber(userRequest.getPhoneNumber());
        user.get().setDateOfBirth(DateTimeUtils.convertStringToDate(userRequest.getDateOfBirth()));
        user.get().setGender(userRequest.getGender());
        user.get().setAddress(userRequest.getAddress());
        user.get().setFirstName(userRequest.getFirstName());
        user.get().setLastName(userRequest.getLastName());
        user.get().setUpdatedAt(new Date());

        log.info("Update user record: {}",user.get());

        userRepository.saveAndFlush(user.get());

        if(user.get().getDevices() != null){
            var deviceRequest = userRequest.getDeviceRequest();
            if (StringUtils.hasText(deviceRequest.getDeviceId())){
               List<Device> devices =  user.get().getDevices();
               Device deviceUpdate = devices.stream()
                       .filter(device ->
                               device.getDeviceId().equalsIgnoreCase(deviceRequest.getDeviceModel()))
                       .findAny().orElse(null);

               if (deviceUpdate!=null){
                   deviceUpdate.setDeviceModel(deviceRequest.getDeviceModel());
                   deviceUpdate.setDeviceType(deviceRequest.getDeviceType());
                   deviceUpdate.setOsVersion(deviceRequest.getOsVersion());
                   deviceUpdate.setAppVersion(deviceRequest.getAppVersion());
                   deviceUpdate.setTrustDevice(deviceRequest.isTrustDevice());
                   log.info("Update device record: {}",deviceUpdate);
                   deviceRepository.save(deviceUpdate);

               }else {
                   Device device = userHandlerService.convertDeviceRequestToUserDevice(user.get(),deviceRequest);
                  /* device.setDeviceId(device.getDeviceId());
                   device.setDeviceModel(device.getDeviceModel());
                   device.setDeviceType(device.getDeviceType());
                   device.setOsVersion(device.getOsVersion());
                   device.setAppVersion(device.getAppVersion());
                   device.setTrustDevice(device.isTrustDevice());
                   device.setUser(userUpdate);*/
                   log.info("Save device record: {}",user.get());
                   deviceRepository.save(device);
               }
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
