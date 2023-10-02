package com.example.rescooker.product.pojo.param;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 添加商品的參數類
 *
 * @author XJX@de.tw
 * @version 1.0
 */

@Data
public class ProductStandardParam implements Serializable {

    /**
     * 商品名稱
     */
    @NotEmpty(message = "添加產品失敗，請填寫產品名稱！")
    private String name;

    /**
     * 商品類別編號
     */
    private Long category_id;

    /**
     * 商品類別名稱
     */
    private String category_name;

    /**
     * 商品圖片
     */
    private String img_url;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品供應商編號
     */
    private Long supplier_id;

    /**
     * 商品供應商名稱
     */
    private String supplier_name;

    /**
     * 商品庫存
     */
    private Integer stock;

    /**
     * 商品售價
     */
    private Integer price;

    /**
     * 商品成本
     */
    private Integer cost;

    /**
     * 商品排序
     */
    private Integer sort;

    /**
     * 商品狀態
     * 0 = 禁用
     * 1 = 啟用
     */
    @NotNull(message = "添加產品失敗，請選擇產品的販售狀態！")
    @Min(value = 0, message = "添加產品失敗，啟用狀態的值必須是0或1！")
    @Max(value = 1, message = "添加產品失敗，啟用狀態的值必須是0或1！")
    private Integer status;
}
