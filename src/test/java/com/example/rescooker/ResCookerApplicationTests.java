package com.example.rescooker;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResCookerApplicationTests {

    @Autowired
    private SqlSession sqlSession;

    @Test
    void contextLoads() {
        System.out.println(sqlSession.getConnection());
    }

}
