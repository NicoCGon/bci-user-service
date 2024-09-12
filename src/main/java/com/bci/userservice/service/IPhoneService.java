package com.bci.userservice.service;

import com.bci.userservice.model.dto.PhoneDto;

import java.util.List;
import java.util.UUID;

public interface IPhoneService {

    void create(List<PhoneDto> phones, UUID userId);
}
