package com.example.rescooker.product.dao.mapper;

import com.example.rescooker.product.pojo.vo.ProductStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ProductMapperTests {

    @Autowired
    private ProductMapper mapper;

    @Test
    void getProductInfoById(){
        ProductStandardVO standardByName = mapper.getStandardById(2L);
        System.out.println("查詢數據完成，查詢結果：" + standardByName);
    }

    @Test
    void getProductInfoByName(){
        String name = "紅茶";
        List<ProductStandardVO> standardByName = mapper.getStandardByName(name);
        System.out.println("查詢數據完成，查詢結果：" + standardByName);
    }

    @Test
    void list(){
        System.out.println("查詢數據完成，查詢結果：" + mapper.list());
    }

}
