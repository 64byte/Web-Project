package com.story.backend.payment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class IamportResponse<T> implements Serializable {

    private static final long serialVersionUID = -2501813264088468980L;

    private int code;

    private String message;

    private T response;

}
