DROP DATABASE IF EXISTS rescookerdb;
CREATE DATABASE rescookerdb CHARSET = utf8;
USE rescookerdb;

###商品管理 - 商品資訊表(包含售價、庫存等完整數據)
DROP TABLE IF EXISTS product_info;
CREATE TABLE product_info
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '商品編號',
    name          VARCHAR(255)  NOT NULL COMMENT '商品名稱',
    category_id   BIGINT COMMENT '商品類別編號',
    category_name VARCHAR(255) COMMENT '商品類別名稱',
    img_url       VARCHAR(255) DEFAULT NULL COMMENT '商品圖片',
    description   VARCHAR(255) DEFAULT NULL COMMENT '商品描述',
    supplier_id   BIGINT  DEFAULT NULL COMMENT '供應商編號',
    supplier_name VARCHAR(255) DEFAULT NULL COMMENT '供應商名稱',
    stock         INT(5)  DEFAULT 0 COMMENT '商品庫存',
    price         INT(5)   NOT NULL COMMENT '商品售價',
    cost          INT(5)   NOT NULL COMMENT '商品成本',
    sort          INT(2)   NOT NULL COMMENT '商品排序',
    status        tinyint  NOT NULL COMMENT '商品販售狀態',
    created_time  datetime NOT NULL COMMENT '商品上架日期',
    modified_time datetime NOT NULL COMMENT '最後修改時間'
);

###商品管理 - 商品分類表
# DROP TABLE IF EXISTS product_category;
# CREATE TABLE product_category
# (
#     id            BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '分類編號',
#     name          VARCHAR(255) NOT NULL COMMENT '分類名稱',
#     description   VARCHAR(255) DEFAULT NULL COMMENT '分類描述',
#     sort          INT(2)       NOT NULL COMMENT '分類排序',
#     created_time  datetime     NOT NULL COMMENT '分類新增日期',
#     modified_time datetime     NOT NULL COMMENT '最後修改時間'
# );

###商品管理 - 商品廠商表
# DROP TABLE IF EXISTS product_maker;
# CREATE TABLE product_maker
# (
#     id             BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '廠商編號',
#     name           VARCHAR(255) NOT NULL COMMENT '廠商名稱',
#     contact_person VARCHAR(255) NOT NULL COMMENT '廠商聯絡人',
#     phone          VARCHAR(255) NOT NULL COMMENT '廠商電話',
#     address        VARCHAR(255) NOT NULL COMMENT '廠商地址',
#     mail           VARCHAR(255) NOT NULL COMMENT '廠商信箱',
#     sort           INT(2)       NOT NULL COMMENT '廠商排序',
#     created_time   datetime     NOT NULL COMMENT '廠商新增日期',
#     modified_time  datetime     NOT NULL COMMENT '最後修改時間'
# );

###交易管理 - 交易紀錄表
DROP TABLE IF EXISTS order_list;
CREATE TABLE order_list
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '訂單編號',
    order_content VARCHAR(255) COMMENT '訂單內容',
    order_total   INT(5) COMMENT '訂單總額',
    created_time  DATETIME COMMENT '訂單交易時間',
    modified_time DATETIME COMMENT '最後修改時間'
);

###交易管理 - 交易明細表
DROP TABLE IF EXISTS order_content;
CREATE TABLE order_content
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '明細編號',
    product_name     VARCHAR(255) NOT NULL COMMENT '商品名稱',
    product_price    INT(3) COMMENT '商品售價',
    product_count    INT(3) COMMENT '交易數量',
    product_subtotal INT(5) COMMENT '商品小計',
    created_time     DATETIME COMMENT '商品下訂時間',
    modified_time    DATETIME COMMENT '最後修改時間'
);

