package com.example.rescooker.product.service;

import com.example.rescooker.product.dao.repository.IProductRepository;
import com.example.rescooker.product.pojo.entity.Product;
import com.example.rescooker.product.pojo.vo.ProductStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ProductRepositoryTests {

    @Autowired
    private IProductService service;




}
