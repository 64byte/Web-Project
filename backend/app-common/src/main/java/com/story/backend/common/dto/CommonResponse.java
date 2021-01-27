package com.story.backend.common.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 2658366165404364587L;

    private int status;

    private String code;

    private Object result;

    @Builder
    public CommonResponse(int status, String code, Object result) {
        this.status = status;
        this.code = code;
        this.result = result;
    }

    public static CommonResponse of(int status, String code, Object result) {
        return new CommonResponse(status, code, result);
    }
}
