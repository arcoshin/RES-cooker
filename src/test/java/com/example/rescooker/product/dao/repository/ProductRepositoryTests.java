package com.example.rescooker.product.dao.repository;

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
    private IProductRepository repository;

    @Test
    void insert() {
        Product product = new Product();
        product.setName("測試產品");

        int insert = repository.insert(product);
        System.out.println("新增數據完成，新增結果：" + insert);
    }

    @Test
    void deleteById() {
        int delete = repository.deleteById(2L);
        System.out.println("刪除數據完成，刪除結果：" + delete);
    }

    @Test
    void updateById() {
        Product product = new Product();
        product.setId(99L);

        int update = repository.updateById(product);
        System.out.println("修改數據完成，修改結果：" + update);
    }

    @Test
    void getStandardById() {
        ProductStandardVO standardById = repository.getStandardById(5L);
        System.out.println("查詢數據完成，查詢結果：" + standardById);

    }

    @Test
    void getStandardByName() {
        String name = "紅茶";
        List<ProductStandardVO> standardByName = repository.getStandardByName(name);
        System.out.println("查詢數據完成，查詢結果：" + standardByName);
    }

    @Test
    void list() {
        System.out.println("查詢數據完成，查詢結果：" + repository.list(1, 5));
    }


}
