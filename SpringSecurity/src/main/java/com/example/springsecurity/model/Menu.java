package com.example.springsecurity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author wzq
 * @Date 2021/9/21
 **/
@Data
@TableName("menu")
public class Menu {

    private Long id;

    private String name;

    private String url;

    private Long parentId;

    private String permission;
}
