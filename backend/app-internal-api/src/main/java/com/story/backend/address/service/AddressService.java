package com.story.backend.address.service;

import com.story.backend.address.dto.AddressRequest;
import com.story.backend.address.dto.AddressResponse;
import com.story.backend.address.dto.UpdateAddressRequest;
import com.story.backend.address.entity.Address;
import com.story.backend.address.repository.AddressRepository;
import com.story.backend.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    private final UserService userService;

    public AddressService(AddressRepository addressRepository, UserService userService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
    }

    /**
     *
     * @param pageable
     * @return
     */
    public Page<AddressResponse> getAllAddresses(Pageable pageable) {
        return addressRepository.findAll(pageable).map(AddressResponse::of);
    }

    /**
     *
     * @param addressRequest
     * @return
     */
    public UUID addNewAddress(@Valid AddressRequest addressRequest) {

        userService.getUserEntityById(addressRequest.getUserId())
                .ifPresent(addressRequest::setUser);

        return addressRepository.save(addressRequest.toEntity())
                .getAddressId();
    }

    /**
     *
     * @param addressId
     * @param updateAddressRequest
     * @return
     */
    public UUID updateAddress(@Valid UUID addressId, @Valid UpdateAddressRequest updateAddressRequest) {

        Address address = addressRepository.findByAddressId(addressId).get();

        return null;
    }

    /**
     *
     * @param addressId
     * @return
     */
    @Valid
    public boolean removeAddress(@NotNull UUID addressId) {
        addressRepository.deleteByAddressId(addressId);
        return true;
    }

}
