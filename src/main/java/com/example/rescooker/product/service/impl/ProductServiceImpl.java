package com.example.rescooker.product.service.impl;

import com.example.rescooker.common.pageInfo2PageData.PageData;
import com.example.rescooker.product.dao.repository.IProductInfoRepository;
import com.example.rescooker.product.pojo.entity.Product;
import com.example.rescooker.product.pojo.param.ProductStandardParam;
import com.example.rescooker.product.pojo.vo.ProductStandardVO;
import com.example.rescooker.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 處理商品資訊的業務實現類
 *
 * @author XJX@de.tw
 * @version 1.0
 */
@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    public ProductServiceImpl() {
        log.debug("創建業務類對象：ProductServiceImpl");
    }

    @Autowired
    private IProductInfoRepository productInfoRepository;


    /**
     * 添加產品
     *
     * @param productStandardParam 產品數據
     */
    @Override
    public void addNew(ProductStandardParam productStandardParam) {
        //新增數據前驗證

        //新增產品數據
        Product product = new Product();
        BeanUtils.copyProperties(productStandardParam,product);
        int row = productInfoRepository.insert(product);

        //新增數據後驗證
        if (row != 1) {
            String message = "添加用戶失敗，服務器忙，請稍後再嘗試！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }

    /**
     * 刪除產品
     *
     * @param id 產品ID
     */
    @Override
    public void delete(Long id) {

    }

    /**
     * 修改產品
     *
     * @param productStandardParam 封裝了被修改數據的ID和新數據的對象
     */
    @Override
    public void updateInfoById(ProductStandardParam productStandardParam) {

    }

    /**
     * 啟用產品
     *
     * @param id 產品ID
     */
    @Override
    public void setEnable(Long id) {

    }

    /**
     * 禁用產品
     *
     * @param id 產品ID
     */
    @Override
    public void setDisable(Long id) {

    }

    /**
     * 根據ID查詢產品
     *
     * @param id 產品ID
     * @return 匹配的查詢結果
     */
    @Override
    public ProductStandardVO getStandardById(Long id) {
        return null;
    }

    /**
     * 查詢產品列表，將使用默認的每頁記錄數
     *
     * @param pageNum 頁碼
     * @return 產品列表
     */
    @Override
    public PageData<ProductStandardVO> list(Integer pageNum) {
        return null;
    }

    /**
     * 查詢產品列表
     *
     * @param pageNum  頁碼
     * @param pageSize 每頁記錄數
     * @return 產品列表
     */
    @Override
    public PageData<ProductStandardVO> list(Integer pageNum, Integer pageSize) {
        return null;
    }
}
