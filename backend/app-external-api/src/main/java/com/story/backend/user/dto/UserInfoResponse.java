package com.story.backend.user.dto;

import com.story.backend.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfoResponse implements Serializable {

    private static final long serialVersionUID = 2546064090487523480L;

    private String email;

    private String fullName;

    private String phoneNum;

    public static UserInfoResponse of(User user) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();

        userInfoResponse.email = user.getEmail();
        userInfoResponse.fullName = user.getFullName();
        userInfoResponse.phoneNum = user.getPhoneNum();

        return userInfoResponse;
    }

}
