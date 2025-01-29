package com.progling.MakeQR.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {
    private Long userSeq;
    private String userId;      // id
    private String userPw;      // pw
    private String userName;    // 이름
}
