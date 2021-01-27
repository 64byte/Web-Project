package com.story.backend.address.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.story.backend.address.entity.Address;
import com.story.backend.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Validated
public class UpdateAddressRequest {

    @NotNull
    private UUID addressId;

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

    private long userId;

    @Setter
    @JsonIgnore
    private User user;

    @Builder
    public UpdateAddressRequest(String receiverName, String receiverPhoneNum, String postalCode, String address1, String address2, long userId) {
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
        this.postalCode = postalCode;
        this.address1 = address1;
        this.address2 = address2;
        this.userId = userId;
    }

    public Address toEntity() {
        return new Address(receiverName, receiverPhoneNum, postalCode, address1, address2, user);
    }

}