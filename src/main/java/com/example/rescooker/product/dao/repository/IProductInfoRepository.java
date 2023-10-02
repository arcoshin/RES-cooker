package com.example.rescooker.product.dao.repository;

import com.example.rescooker.common.pageInfo2PageData.PageData;
import com.example.rescooker.product.pojo.entity.Product;
import com.example.rescooker.product.pojo.vo.ProductStandardVO;

/**
 * 處理商品資訊的數據訪問接口
 *
 * @author XJX@de.tw
 * @version 1.0
 */
public interface IProductInfoRepository {

    /**
     * 插入產品數據
     *
     * @param product 產品數據
     * @return 受影響的行數
     */
    int insert(Product product);

    /**
     * 根據用戶id刪除產品數據
     *
     * @param id 產品ID
     * @return 受影響的行數
     */
    int deleteById(Long id);

    /**
     * 根據產品ID修改產品數據
     *
     * @param product 封裝了產品ID和新數據的對象
     * @return 受影響的行數
     */
    int updateById(Product product);

    /**
     * 根據產品ID查詢產品數據
     *
     * @param id 產品ID
     * @return 匹配的產品數據查詢結果，若無則返回null
     */
    ProductStandardVO getStandardById(Long id);

    /**
     * 查詢產品列表
     *
     * @param pageNum  頁碼
     * @param pageSize 每頁記錄數
     * @return 產品數據列表
     */
    PageData<ProductStandardVO> list(Integer pageNum, Integer pageSize);

}
