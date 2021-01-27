package com.story.backend.common.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 2658366165404364587L;

    private HttpStatus status;

    private String code;

    private Object result;

    @Builder
    public CommonResponse(HttpStatus status, String code, Object result) {
        this.status = status;
        this.code = code;
        this.result = result;
    }

    public static CommonResponse of(HttpStatus status, String code, Object result) {
        return new CommonResponse(status, code, result);
    }
}
