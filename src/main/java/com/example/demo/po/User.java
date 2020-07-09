package com.example.demo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: copy
 * @description: user实体
 * @author: tianpanke
 * @create: 2020-07-09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;

    private String name;

    private Integer age;

    private String address;

    private String sex;
}
