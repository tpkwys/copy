package com.example.demo.transfer;

import com.example.demo.po.User;
import com.example.demo.vo.UserVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @program: copy
 * @description:
 * @author: tianpanke
 * @create: 2020-07-09
 **/
@Mapper
public interface UserTransfer {
    List<UserVo> entityToVo(List<User> user);
}
