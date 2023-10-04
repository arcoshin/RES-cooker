package com.example.rescooker.product.service;

import com.example.rescooker.common.pageInfo2PageData.PageData;
import com.example.rescooker.product.pojo.param.ProductStandardParam;
import com.example.rescooker.product.pojo.vo.ProductStandardVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 處理產品數據的業務接口
 *
 * @author XJX@de.tw
 * @version 1.0
 */
@Transactional
public interface IProductService {

    /**
     * 啟用狀態的顯示文本
     */
    String ENABLE_TEXT[] = {"禁用", "啟用"};
    
    /**
     * 添加產品
     *
     * @param productStandardParam 產品數據
     */
    void addNew(ProductStandardParam productStandardParam);

    /**
     * 刪除產品
     *
     * @param id 產品ID
     */
    void deleteById(Long id);

    /**
     * 修改產品
     *
     * @param productStandardParam 封裝了被修改數據的ID和新數據的對象
     */
    void updateInfoById(ProductStandardParam productStandardParam);

    /**
     * 啟用產品
     *
     * @param id 產品ID
     */
    void setEnable(Long id);

    /**
     * 禁用產品
     *
     * @param id 產品ID
     */
    void setDisable(Long id);

    /**
     * 根據ID查詢產品
     *
     * @param id 產品ID
     * @return 匹配的查詢結果
     */
    ProductStandardVO getStandardById(Long id);

    /**
     * 查詢產品列表，將使用默認的每頁記錄數
     *
     * @param pageNum 頁碼
     * @return 產品列表
     */
    PageData<ProductStandardVO> list(Integer pageNum);

    /**
     * 查詢產品列表
     *
     * @param pageNum  頁碼
     * @param pageSize 每頁記錄數
     * @return 產品列表
     */
    PageData<ProductStandardVO> list(Integer pageNum, Integer pageSize);
    
}
