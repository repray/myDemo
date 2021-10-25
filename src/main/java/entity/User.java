package entity;

import lombok.Data;

/**
 * @Author Li Yang
 * @Created on 2021/10/11.
 * @Desc
 */
@Data
public class User {

    private Integer age;

    private String name;

    private Integer password;

    //性别1 男 2女
    private Integer sex;


}
