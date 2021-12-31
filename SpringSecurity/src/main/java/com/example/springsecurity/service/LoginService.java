package com.example.springsecurity.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author wzq
 * @Date 2021/9/21
 **/
public class LoginService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //判断该用户是否存在
        if (!"admin".equals(userName)){
            throw new UsernameNotFoundException("用户名不存在");
        }

        //从数据库获取加密后的密码
        String pwd = "$2a$10$2R/M6iU3mCZt3ByG7kwYTeeW0w7/UqdeXrb27zkBIizBvAven0/na";

        //第三个参数为权限
        return new User(userName,pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,"));
    }
}
