package com.story.backend.address.dto;

import com.story.backend.address.entity.Address;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressResponse implements Serializable {

    private static final long serialVersionUID = 3536370460988966521L;

    private long id;

    private UUID addressId;

    private String receiverName;

    private String receiverPhoneNum;

    private String postalCode;

    private String address1;

    private String address2;

    private long userId;

    @Builder
    public AddressResponse(long id, UUID addressId, String receiverName, String receiverPhoneNum, String postalCode, String address1, String address2, long userId) {
        this.id = id;
        this.addressId = addressId;
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
        this.postalCode = postalCode;
        this.address1 = address1;
        this.address2 = address2;
        this.userId = userId;
    }

    public static AddressResponse of(Address address) {
       return new AddressResponse(
               address.getId(),
               address.getAddressId(),
               address.getReceiverName(),
               address.getReceiverPhoneNum(),
               address.getPostalCode(),
               address.getAddress1(),
               address.getAddress2(),
               address.getUser() != null ? address.getUser().getId() : -1);
    }

}
