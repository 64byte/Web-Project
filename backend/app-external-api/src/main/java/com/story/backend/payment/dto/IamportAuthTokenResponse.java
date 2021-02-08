package com.story.backend.payment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class IamportAuthTokenResponse implements Serializable {
    private static final long serialVersionUID = -1720297776843952014L;

    private String access_token;

    private long now;

    private long expired_at;
}
