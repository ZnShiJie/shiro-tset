package com.example.springbootshiro;

import com.example.springbootshiro.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    UserMapper usermapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testGet() {
        System.out.println(usermapper.getOne("xin", "123"));
    }

}
