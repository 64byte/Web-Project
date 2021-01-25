package com.story.backend.address.dto;

import com.story.backend.address.entity.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
public class AddNewAddressRequest {

    @NotBlank
    private String receiverName;

    @NotBlank
    private String receiverPhoneNum;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String address1;

    @NotBlank
    private String address2;

    public Address toEntity() {
        return new Address(receiverName, receiverPhoneNum, postalCode, address1, address2);
    }

}
