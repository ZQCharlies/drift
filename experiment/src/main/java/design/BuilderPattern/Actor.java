package design.BuilderPattern;

import lombok.Data;

/**
 * @Author wzq
 * @Date 2021/8/4
 * Actor 角色类：复杂产品
 **/
@Data
public class Actor {

    private String type;//角色类型

    private String sex;//性别

    private String face;//脸型

    private String costume;//服饰

    private String hairstyle;//服饰

}
