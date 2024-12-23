package com.daletcode.service.handler;

import com.daletcode.dto.DeviceRequest;
import com.daletcode.dto.DeviceResponse;
import com.daletcode.dto.UserRequest;
import com.daletcode.dto.UserResponse;
import com.daletcode.model.Device;
import com.daletcode.model.User;
import com.daletcode.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.daletcode.constant.Constant.SYSTEM;
import static com.daletcode.constant.Constant.USER_STATUS_ACTIVE;

@Service
@Slf4j
public class UserHandlerService {

    public void usernameHasText(String username){
       if(StringUtils.hasText(username)){
           return;
       }
       log.info("Username is empty");
      throw new IllegalArgumentException("Username is empty");
    }

    public void phoneNumberHasText(String phoneNumber) {
        if (StringUtils.hasText(phoneNumber)) {
            return;
        }
        log.info("Phone Number is empty");
        throw new IllegalArgumentException("Phone Number is empty");
    }

    public UserResponse convertUserToUserResponse(final User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .dateOfBirth(user.getDateOfBirth().toString())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .address(user.getAddress())
                .userType(user.getUserType())
                .status(user.getStatus())
                .createdBy(user.getCreatedBy())
                .createdAt(String.valueOf(user.getCreatedAt()))
                .updatedBy(user.getUpdatedBy())
                .updatedAt(String.valueOf(user.getUpdatedAt()))
                .build();
    }

    public User convertUserToUserRequest( final UserRequest userRequest){
      User user= new User();
      user.setUsername(userRequest.getUsername());
      user.setFirstName(userRequest.getFirstName());
      user.setLastName(userRequest.getLastName());
      user.setGender(userRequest.getGender());
      user.setDateOfBirth(DateTimeUtils.convertStringToDate(userRequest.getDateOfBirth()));
      user.setPhoneNumber(userRequest.getPhoneNumber());
      user.setEmail(userRequest.getEmail());
      user.setAddress(userRequest.getAddress());
      user.setUserType(userRequest.getUserType());
      user.setStatus(USER_STATUS_ACTIVE);
      user.setCreatedBy(SYSTEM);

      return user;
    }

    public Device convertDeviceRequestToUserDevice(final User user,final DeviceRequest deviceRequest){
        Device device= new Device();

        device.setDeviceId(deviceRequest.getDeviceId());
        device.setDeviceId(deviceRequest.getDeviceId());
        device.setDeviceType(deviceRequest.getDeviceType());
        device.setOsVersion(deviceRequest.getOsVersion());
        device.setAppVersion(deviceRequest.getAppVersion());
        device.setTrustDevice(deviceRequest.isTrustDevice());
        device.setUser(user);

        return device;
    }

    public DeviceResponse convertUserDeviceToDeviceResponse(final Device device){

        return DeviceResponse.builder()
                .id(device.getId())
                .deviceId(device.getDeviceId())
                .deviceType(device.getDeviceType())
                .deviceModel(device.getDeviceModel())
                .osVersion(device.getOsVersion())
                .appVersion(device.getAppVersion())
                .trustDevice(device.isTrustDevice())
                .lastLogin(device.getLastLogin())
                .status(device.getStatus())
                .build();

    }
}
