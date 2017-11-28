package com.example.demo.service;

import com.example.demo.domain.School;
import com.example.demo.domain.User;
import com.example.demo.domain.UserTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * mongoTemplate
 *
 * @author orange
 * @Time 2017/11/27 0027
 */
@Service
public class UserTemplateService {

    @Autowired
    private UserTemplate userTemplate;


    public void save() {
        User user = new User();
        user.createUserCase();
        userTemplate.save(user);
    }

    public void repalce() {
        User user = userTemplate.findById("5a1bc470160e23b788a18eb7");
        user.setName("张三");
        userTemplate.replace(user);
        System.out.println("替换后的效果");
    }


    public void update() {
        String name = "张三";
        int age = 1;
        int num = 2;
        userTemplate.update(name, age, num);
    }

    public void addToSet() {
        String name = "张三";

        List<School> schoolList = new ArrayList<>();
        schoolList.add(new School(111, "学校名称5", 2015));
        schoolList.add(new School(1123, "学校名称6", 2016));

        userTemplate.addToList(name, schoolList);
    }

    public void findByNativeQuery() {
        String name = "张三";
        List<User> userList = userTemplate.nativeQuery(name);

        System.out.println("查询结果：----" + userList.toString());
    }

    @PostConstruct
    public void findAll() {
        int age = 0;
        List<User> userList = userTemplate.findAll(age);

        System.out.println("查询结果：----" + userList.toString());
    }
}
