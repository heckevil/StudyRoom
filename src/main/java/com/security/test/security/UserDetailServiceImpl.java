package com.security.test.security;

import com.security.test.member.MemberMapper;
import com.security.test.member.MemberService;
import com.security.test.member.Role;
import com.security.test.member.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private MemberMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = mapper.selUser(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user == null) {
            return (UserDetails) new UsernameNotFoundException("등록되지 않은 사용자 입니다");
        }
        if (("admin@exemple.com").equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }
        return new User(user.getId(), user.getPw(), authorities);
    }

    public int join(UserEntity param) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        param.setPw(passwordEncoder.encode(param.getPw()));
        return mapper.join(param);
    }
}
