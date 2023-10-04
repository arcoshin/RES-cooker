package com.example.rescooker.product.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rescooker.product.pojo.entity.Product;
import com.example.rescooker.product.pojo.vo.ProductStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 處理商品資訊的Mapper接口
 *
 * @author XJX@de.tw
 * @version 1.0
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 根據產品ID查詢產品數據
     *
     * @param id 產品名稱
     * @return 匹配的產品數據查詢結果，若無則返回null
     */
    ProductStandardVO getStandardById(Long id);

    /**
     * 根據產品名稱查詢產品數據
     *
     * @param name 產品名稱
     * @return 匹配的產品數據查詢結果，若無則返回null
     */
    List<ProductStandardVO> getStandardByName(String name);

    /**
     * 查詢產品列表
     *
     * @return 產品數據列表
     */
    List<ProductStandardVO> list();
}
