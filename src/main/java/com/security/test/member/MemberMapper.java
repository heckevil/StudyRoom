package com.security.test.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int join(UserEntity param);
    UserEntity selUser(String username);
}
