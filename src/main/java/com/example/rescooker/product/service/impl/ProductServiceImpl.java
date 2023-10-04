package com.example.rescooker.product.service.impl;

import com.example.rescooker.common.exception.ServiceCode;
import com.example.rescooker.common.exception.ServiceException;
import com.example.rescooker.common.pageInfo2PageData.PageData;
import com.example.rescooker.product.dao.repository.IProductRepository;
import com.example.rescooker.product.pojo.entity.Product;
import com.example.rescooker.product.pojo.param.ProductStandardParam;
import com.example.rescooker.product.pojo.vo.ProductStandardVO;
import com.example.rescooker.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 處理商品資訊的業務實現類
 *
 * @author XJX@de.tw
 * @version 1.0
 */
@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    /**
     * 自動從配置文件獲取以下訊息
     */

    //獲取分頁每頁數據數
    @Value("${res-cooker.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;

    public ProductServiceImpl() {
        log.debug("創建業務類對象：ProductServiceImpl");
    }

    @Autowired
    private IProductRepository productRepository;


    /**
     * 添加產品
     *
     * @param productStandardParam 產品數據
     */
    @Override
    public void addNew(ProductStandardParam productStandardParam) {
        log.debug("開始處理【添加產品】的業務，參數：{}", productStandardParam);

        //重名驗證
        String name = productStandardParam.getName();
        List<ProductStandardVO> standardByName = productRepository.getStandardByName(name);
        if (standardByName.size() != 0) {
            String message = "添加產品失敗，重複的產品名稱！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }

        //新增數據
        Product product = new Product();
        BeanUtils.copyProperties(productStandardParam, product);
        int row = productRepository.insert(product);

        //校驗數據
        if (row != 1) {
            String message = "添加產品失敗，服務器忙碌中，請稍後再嘗試！";
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
    public void deleteById(Long id) {
        log.debug("開始處理【根據ID刪除產品】的業務，參數：{}", id);
        int deleteById = productRepository.deleteById(id);

        //校驗
        if (deleteById < 1) {
            String message = "刪除產品失敗，服務器忙碌中，請稍後再嘗試！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_DELETE, message);
        }
    }

    /**
     * 修改產品
     *
     * @param productStandardParam 封裝了被修改數據的ID和新數據的對象
     */
    @Override
    public void updateInfoById(ProductStandardParam productStandardParam) {
        log.debug("開始處理【修改產品】的業務，參數：{}", productStandardParam);

        //修改數據
        Product product = new Product();
        BeanUtils.copyProperties(productStandardParam, product);
        int update = productRepository.updateById(product);

        //校驗
        if (update < 1) {
            String message = "修改產品失敗，服務器忙碌中，請稍後再嘗試！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    /**
     * 啟用產品
     *
     * @param id 產品ID
     */
    @Override
    public void setEnable(Long id) {
        log.debug("開始處理【啟用產品】的業務，參數：{}", id);
        updateEnableById(id, 1);
    }

    /**
     * 禁用產品
     *
     * @param id 產品ID
     */
    @Override
    public void setDisable(Long id) {
        log.debug("開始處理【禁用產品】的業務，參數：{}", id);
        updateEnableById(id, 0);
    }

    private void updateEnableById(Long id, Integer enable) {
        log.debug("開始處理【{}產品】的業務，ID：{}，目標狀態：{}", ENABLE_TEXT[enable], id, enable);

        //獲取將修改的產品對象
        ProductStandardVO standardById = productRepository.getStandardById(id);
        if (standardById == null) {
            String message = ENABLE_TEXT[enable] + "產品失敗，嘗試訪問的數據不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        //執行修改
        Product product = new Product();
        product.setId(id);
        product.setStatus(enable);

        log.debug("即將修改數據，參數：{}", product);
        int update = productRepository.updateById(product);
        if (update != 1) {
            String message = ENABLE_TEXT[enable] + "產品失敗，服務器忙碌中，請稍後再次嘗試！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    /**
     * 根據ID查詢產品
     *
     * @param id 產品ID
     * @return 匹配的查詢結果
     */
    @Override
    public ProductStandardVO getStandardById(Long id) {
        log.debug("開始處理【根據ID查詢產品】的業務，參數：{}", id);
        ProductStandardVO standardById = productRepository.getStandardById(id);
        if (standardById == null) {
            String message = "獲取產品詳情失敗，嘗試訪問的產品數據不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return standardById;
    }

    /**
     * 查詢產品列表，將使用默認的每頁記錄數
     *
     * @param pageNum 頁碼
     * @return 產品列表
     */
    @Override
    public PageData<ProductStandardVO> list(Integer pageNum) {
        log.debug("開始處理【查詢產品列表】的業務，頁碼：{}", pageNum);
        PageData<ProductStandardVO> pageData = productRepository.list(pageNum, defaultQueryPageSize);
        return pageData;
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
        log.debug("開始處理【查詢產品列表】的業務，頁碼：{}，每頁記錄數：{}", pageNum, pageSize);
        PageData<ProductStandardVO> pageData = productRepository.list(pageNum, pageSize);
        return pageData;
    }
}
