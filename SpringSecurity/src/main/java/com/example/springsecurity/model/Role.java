package com.example.springsecurity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author wzq
 * @Date 2021/9/21
 **/
@Data
@TableName("role")
public class Role {

    private Long id;

    private String name;
}
