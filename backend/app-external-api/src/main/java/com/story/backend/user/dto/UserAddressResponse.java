package com.story.backend.user.dto;

import com.story.backend.address.entity.Address;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAddressResponse implements Serializable {

    private static final long serialVersionUID = -2494247463403996230L;

    private UUID addressId;

    private String receiverName;

    private String receiverPhoneNum;

    private String postalCode;

    private String address1;

    private String address2;

    public static UserAddressResponse of(Address address) {
        UserAddressResponse userAddressResponse = new UserAddressResponse();

        userAddressResponse.addressId = address.getAddressId();
        userAddressResponse.receiverName = address.getReceiverName();
        userAddressResponse.receiverPhoneNum = address.getReceiverPhoneNum();
        userAddressResponse.postalCode = address.getPostalCode();
        userAddressResponse.address1 = address.getAddress1();
        userAddressResponse.address2 = address.getAddress2();

        return userAddressResponse;
    }

}
