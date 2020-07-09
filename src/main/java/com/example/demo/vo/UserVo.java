package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: copy
 * @description: user vo
 * @author: tianpanke
 * @create: 2020-07-09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private String id;

    private String name;

    private Integer age;

    private String address;

    private String sex;
}
