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
public interface ProductInfoMapper extends BaseMapper<Product> {

    ProductStandardVO getStandardById(Long id);

    List<ProductStandardVO> list();
}
