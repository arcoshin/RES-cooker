package com.example.rescooker.product.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品的標準VO類
 *
 * @author XJX@de.tw
 * @version 1.0
 */
@Data
public class ProductStandardVO implements Serializable {

    /**
     * 商品編號
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品名稱
     */
    private String name;

    /**
     * 商品圖片
     */
    private String imgUrl;

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
    private Integer status;
}
