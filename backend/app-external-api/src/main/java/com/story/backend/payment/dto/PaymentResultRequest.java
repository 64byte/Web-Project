package com.story.backend.payment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Validated
public class PaymentResultRequest {

    @NotBlank
    private String impUid;

    @NotBlank
    private String merchantId;

    /**
     * merchantId format: cartId + "_" + timetamp
     * ex) 09fa4036-b86f-4fb6-89fa-edd051171594_1612172208745
     * @return
     */
    public UUID parseCartIdFromMerchantId() {
        final int lengthOfSplitItems = 2;

        String[] cartIdAndTimestamp = merchantId.split("_");
        if (cartIdAndTimestamp.length != lengthOfSplitItems) {
            throw new RuntimeException();
        }

        return UUID.fromString(cartIdAndTimestamp[0]);
    }
}
