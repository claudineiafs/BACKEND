CREATE TABLE `product`
(
    product_id VARCHAR(36) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_description VARCHAR(500) NOT NULL,
    product_price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (product_id)
);
