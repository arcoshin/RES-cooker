CREATE DATABASE REScookerDB char set UTF8;
USE REScookerDB;
SHOW CREATE DATABASE REScookerDB;
CREATE TABLE customFX
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '交易紀錄編號',
    list_id BIGINT NOT NULL COMMENT '訂單編號',
    product_id BIGINT NOT NULL COMMENT '商品編號',
    trading INT(10) NOT NULL COMMENT '交易數量',
    created_time DATETIME COMMENT '訂單交易時間',
    qualify_time DATETIME COMMENT '最後修改時間'

)