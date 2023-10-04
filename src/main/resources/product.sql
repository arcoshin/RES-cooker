DROP DATABASE IF EXISTS rescookerdb;
CREATE DATABASE rescookerdb CHARSET = utf8;
USE rescookerdb;

###產品管理 - 產品資訊表(包含售價、庫存等完整數據)
DROP TABLE IF EXISTS product_info;
CREATE TABLE product_info
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '產品編號',
    name          VARCHAR(255) NOT NULL COMMENT '產品名稱',
    img_url       VARCHAR(255) DEFAULT NULL COMMENT '產品圖片',
    stock         INT(5)       DEFAULT 0 COMMENT '產品庫存',
    price         INT(5)       DEFAULT 0 COMMENT '產品售價',
    cost          INT(5)       DEFAULT 0 COMMENT '產品成本',
    sort          INT(2)       DEFAULT 99 COMMENT '產品排序',
    status        tinyint      DEFAULT 1 COMMENT '產品販售狀態',
    created_time  datetime     NOT NULL COMMENT '產品販售日期',
    modified_time datetime     NOT NULL COMMENT '最後修改時間'
);

###交易管理 - 交易明細表
DROP TABLE IF EXISTS order_detail;
CREATE TABLE order_detail
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '單項交易序號',
    order_id      BIGINT   NOT NULL COMMENT '訂單編號',
    product_id    BIGINT   NOT NULL COMMENT '產品編號',
    product_count INT(3)   NOT NULL COMMENT '下單數量',
    created_time  datetime NOT NULL COMMENT '訂單生成時間',
    modified_time datetime NOT NULL COMMENT '最後修改時間'
);


