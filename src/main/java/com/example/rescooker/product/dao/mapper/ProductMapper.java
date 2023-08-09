package com.example.rescooker.product.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rescooker.product.pojo.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * 處理商品數據的Mapper接口
 *
 * @author XJX@tedu.tw
 * @version 1.0
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
    
}
