package com.story.backend.order.dto;

import com.story.backend.order.entity.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.validation.annotation.Validated;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Validated
public class GenerateOrderRequest {

    private String impUid;

    private String merchantUid;

    private String payMethod;

    private String status;

    private long paidAmount;

    private String applyNum;

    public GenerateOrderRequest(String impUid, String merchantUid, String payMethod, String status, long paidAmount, String applyNum) {
        this.impUid = impUid;
        this.merchantUid = merchantUid;
        this.payMethod = payMethod;
        this.status = status;
        this.paidAmount = paidAmount;
        this.applyNum = applyNum;
    }

    public Order toEntity() {
        return new Order(impUid, merchantUid, payMethod, status, paidAmount, applyNum);
    }

}
