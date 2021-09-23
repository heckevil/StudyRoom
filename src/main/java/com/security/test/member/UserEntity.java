package com.security.test.member;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    private String unm;
    private String pw;
    private int uno;
    private String regdt;
}
