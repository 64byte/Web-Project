package com.story.backend.address.controller;

import com.story.backend.address.dto.AddressRequest;
import com.story.backend.address.dto.UpdateAddressRequest;
import com.story.backend.address.service.AddressService;
import com.story.backend.common.dto.CommonResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/backoffice/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllAddress(Pageable pageable) {
        return new ResponseEntity<>
                (CommonResponse.of(HttpStatus.OK, null, addressService.getAllAddresses(pageable)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addNewAddress(@RequestBody AddressRequest addressRequest) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.CREATED, null, addressService.addNewAddress(addressRequest)), HttpStatus.CREATED);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<CommonResponse> updateAddress(@PathVariable UUID addressId, @RequestBody UpdateAddressRequest updateAddressRequest) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.OK, null, addressService.updateAddress(addressId, updateAddressRequest)), HttpStatus.OK);
    }

    @DeleteMapping("/{addressId}}")
    public ResponseEntity<CommonResponse> removeAddress(@PathVariable UUID addressId) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.OK, null, addressService.removeAddress(addressId)), HttpStatus.OK);
    }
}
