package com.story.backend.address.service;

import com.story.backend.address.dto.AddNewAddressRequest;
import com.story.backend.address.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public UUID addNewAddress(@Valid AddNewAddressRequest addNewAddressRequest) {
        return addressRepository.save(addNewAddressRequest.toEntity()).getAddressId();
    }

}
