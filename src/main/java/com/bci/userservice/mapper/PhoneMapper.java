package com.bci.userservice.mapper;

import com.bci.userservice.model.Phone;
import com.bci.userservice.model.dto.PhoneDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class PhoneMapper {

    public static Phone mapToPhone(PhoneDto phoneDto, UUID userId){
        LocalDateTime now = LocalDateTime.now();

        return Phone.builder()
                .userId(userId)
                .number(phoneDto.getNumber())
                .cityCode(phoneDto.getCitycode())
                .countryCode(phoneDto.getContrycode())
                .createdAt(now)
                .modifiedAt(now)
                .build();
    }
}
