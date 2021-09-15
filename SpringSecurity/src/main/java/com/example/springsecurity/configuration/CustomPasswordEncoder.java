package com.example.springsecurity.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author wzq
 * @Date 2021/9/15
 * @Desc 自定义密码加密方式
 **/
public class CustomPasswordEncoder implements PasswordEncoder {


    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
