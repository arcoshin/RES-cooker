package com.example.rescooker.product.dao.repository.impl;

import com.example.rescooker.common.pageInfo2PageData.PageData;
import com.example.rescooker.common.pageInfo2PageData.PageInfoToPageDataConverter;
import com.example.rescooker.product.dao.mapper.ProductMapper;
import com.example.rescooker.product.dao.repository.IProductRepository;
import com.example.rescooker.product.pojo.entity.Product;
import com.example.rescooker.product.pojo.vo.ProductStandardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 處理商品資訊的數據訪問實現類
 *
 * @author XJX@de.tw
 * @version 1.0
 */
@Slf4j
@Repository
public class ProductRepositoryImpl implements IProductRepository {

    public ProductRepositoryImpl() {
        log.info("創建存儲庫對象：ProductRepositoryImpl");
    }

    @Autowired
    private ProductMapper productMapper;

    /**
     * 插入產品數據
     *
     * @param product 產品數據
     * @return 受影響的行數
     */
    @Override
    public int insert(Product product) {
        log.debug("開始執行【插入產品】的數據訪問，參數：{}", product);
        return productMapper.insert(product);
    }

    /**
     * 根據用戶id刪除產品數據
     *
     * @param id 產品ID
     * @return 受影響的行數
     */
    @Override
    public int deleteById(Long id) {
        log.debug("開始執行【根據ID刪除產品】的數據訪問，參數：{}", id);
        return productMapper.deleteById(id);
    }

    /**
     * 根據產品ID修改產品數據
     *
     * @param product 封裝了產品ID和新數據的對象
     * @return 受影響的行數
     */
    @Override
    public int updateById(Product product) {
        log.debug("開始執行【根據ID修改產品】的數據訪問，參數：{}", product);
        return productMapper.updateById(product);
    }

    /**
     * 根據產品ID查詢產品數據
     *
     * @param id 產品ID
     * @return 匹配的產品數據查詢結果，若無則返回null
     */
    @Override
    public ProductStandardVO getStandardById(Long id) {
        log.debug("開始執行【根據ID查詢產品】的數據訪問，參數：{}", id);
        return productMapper.getStandardById(id);
    }

    /**
     * 根據產品名稱查詢產品數據
     *
     * @param name 產品名稱
     * @return 匹配的產品數據查詢結果，若無則返回null
     */
    @Override
    public List<ProductStandardVO> getStandardByName(String name) {
        log.debug("開始執行【根據名稱查詢產品】的數據訪問，參數：{}", name);
        return productMapper.getStandardByName(name);
    }

    /**
     * 查詢產品列表
     *
     * @param pageNum  頁碼
     * @param pageSize 每頁記錄數
     * @return 產品數據列表
     */
    @Override
    public PageData<ProductStandardVO> list(Integer pageNum, Integer pageSize) {
        log.debug("開始執行【查詢產品列表】的數據訪問，頁碼：{}，每頁記錄數：{}", pageNum, pageSize);

        PageHelper.startPage(pageNum, pageSize);
        List<ProductStandardVO> list = productMapper.list();
        PageInfo<ProductStandardVO> pageInfo = new PageInfo<>(list);
        PageData<ProductStandardVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }
}
