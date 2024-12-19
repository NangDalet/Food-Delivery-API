package com.daletcode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Date convertStringToDate(String dateOfBirth) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            log.error("Error parsing date", e);
            return new Date(); // Return the current date as fallback
        }
    }
}
