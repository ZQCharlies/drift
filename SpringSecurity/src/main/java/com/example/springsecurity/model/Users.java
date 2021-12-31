package com.example.springsecurity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author wzq
 * @Date 2021/9/21
 **/
@Data
@TableName("t_staking_admin")
public class Users {

    private Long id;

    private String userName;

    private String password;
}
