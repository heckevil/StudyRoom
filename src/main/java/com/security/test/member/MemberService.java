package com.security.test.member;

import com.security.test.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    UserDetailServiceImpl userDetailService;
    public void join (UserEntity param){
        userDetailService.join(param);
    }
}
