package com.example.demo;

import com.example.demo.po.User;
import com.example.demo.transfer.UserTransfer;
import com.example.demo.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // MapStruct>Spring>Apache
        //这里拿100w条数据做初始化
        List<User> users=new ArrayList<>(1000000);
        for(int i=0;i<1000;i++){
            User user=new User(UUID.randomUUID().toString(),UUID.randomUUID().toString(),i,UUID.randomUUID().toString(),UUID.randomUUID().toString());
            users.add(user);
        }
        System.out.println("开始拷贝----------------------------");
        testApacheBeanUtils(users);
        testSpringBeanUtils(users);
        testMapStruct(users);

    }
    public static void testApacheBeanUtils(List<User> users){
        long start=System.currentTimeMillis();
        List<UserVo> userVos=new ArrayList<>(1000000);
        users.forEach(item->{
            UserVo userVo=new UserVo();
            try{
                BeanUtils.copyProperties(userVo,item);
            }catch (Exception e){
                e.printStackTrace();
            }
            userVos.add(userVo);
        });
        System.out.println(userVos.get(0));
        System.out.println("集合大小参数验证"+userVos.size()+"Apache的BeanUtils耗时："+(System.currentTimeMillis()-start)+"ms");
    }
    public static void testSpringBeanUtils(List<User> users){
        long start=System.currentTimeMillis();
        List<UserVo> userVos=new ArrayList<>(1000000);
        users.forEach(item->{
            UserVo userVo=new UserVo();
            try{
                org.springframework.beans.BeanUtils.copyProperties(item,userVo);
            }catch (Exception e){
                e.printStackTrace();
            }
            userVos.add(userVo);
        });
        System.out.println(userVos.get(0));
        System.out.println("集合大小参数验证"+userVos.size()+"Spring的BeanUtils耗时："+(System.currentTimeMillis()-start)+"ms");
    }

    public static void testMapStruct(List<User> users){
        long start=System.currentTimeMillis();
        List<UserVo> userVos = Mappers.getMapper(UserTransfer.class).entityToVo(users);
        long end = System.currentTimeMillis();
        System.out.println(userVos.get(0));
        System.out.println("集合大小参数验证"+userVos.size()+"MapStruct耗时："+(end-start)+"ms");
    }


}
