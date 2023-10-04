package com.example.rescooker.product.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品資訊的實體類
 *
 * @author XJX@tedu.tw
 * @version 1.0
 */
@Data
@TableName("product_info")
public class Product implements Serializable {
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

    /**
     * 商品上架時間
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 最後修改時間
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;
}
