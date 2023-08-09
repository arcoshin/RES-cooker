package com.example.rescooker.core.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置類
 *
 * @author XJX@tedu.tw
 * @version 1.0
 */
@Slf4j
@Configuration
@MapperScan("com.example.rescooker.product.dao.mapper")
public class MyBatisConfiguration {
    public MyBatisConfiguration() {
        log.info("創建配置類對象：MyBatisConfiguration");
    }
}
