package com.bci.userservice.service.impl;

import com.bci.userservice.mapper.PhoneMapper;
import com.bci.userservice.model.dto.PhoneDto;
import com.bci.userservice.repository.PhoneRepository;
import com.bci.userservice.service.IPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhoneService implements IPhoneService {

    private final PhoneRepository phoneRepository;
    public void create(List<PhoneDto> phones, UUID userId) {
        if (phones.isEmpty()) {
            return;
        }

        phones.stream()
                .map(phone -> PhoneMapper.mapToPhone(phone, userId))
                .forEach(this.phoneRepository::save);
    }

}
