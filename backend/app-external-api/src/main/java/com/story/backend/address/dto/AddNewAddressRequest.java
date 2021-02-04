package com.story.backend.address.dto;

import com.story.backend.address.entity.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Validated
public class AddNewAddressRequest {

    @NotBlank
    private String receiverName;

    @NotBlank
    private String receiverPhoneNum;

    @Email
    @NotBlank
    private String receiverEmail;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String address1;

    @NotBlank
    private String address2;

    public Address toEntity() {
        return new Address(receiverName, receiverPhoneNum, receiverEmail, postalCode, address1, address2, null);
    }

}
