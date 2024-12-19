package com.daletcode.service.impl;

import com.daletcode.dto.UserRequest;
import com.daletcode.dto.UserResponse;
import com.daletcode.model.Device;
import com.daletcode.model.User;
import com.daletcode.repository.DeviceRepository;
import com.daletcode.repository.UserRepository;
import com.daletcode.service.UserHandlerService;
import com.daletcode.service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }

    @Transactional
    @Override
    public UserResponse create(UserRequest userRequest) {

       userHandlerService.usernameHasText(userRequest.getUsername());
       userHandlerService.phoneNumberHasText(userRequest.getPhoneNumber());

        User user = modelMapper.map(userRequest, User.class);
        user.setDateOfBirth(userHandlerService.convertStringToDate(String.valueOf(userRequest.getDateOfBirth())));
        log.info("Creating user: {}", user);
        userRepository.saveAndFlush(user);

        if(user.getId()!=null){
            final UserRequest.DeviceRequest deviceRequest = userRequest.getDeviceRequest();
            Device device = new Device();
            device.setDeviceId(deviceRequest.getDeviceId());
            device.setDeviceModel(deviceRequest.getDeviceModel());
            device.setDeviceType(deviceRequest.getDeviceType());
            device.setOsVersion(deviceRequest.getOsVersion());
            device.setAppVersion(deviceRequest.getAppVersion());
            device.setTrustDevice(deviceRequest.isTrustDevice());
            device.setUser(user);
            deviceRepository.save(device);
        }

        return null;
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
