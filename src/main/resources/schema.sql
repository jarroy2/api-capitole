-- Create the brand table
DROP TABLE IF EXISTS brand;

CREATE TABLE brand (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE INDEX idx_brand_id ON brand (id);

-- Create the product table
DROP TABLE IF EXISTS product;

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE INDEX idx_product_id ON product (id);

-- Create the price table
DROP TABLE IF EXISTS price;

CREATE TABLE price (
     id BIGINT PRIMARY KEY,
     brand_id BIGINT NOT NULL,
     start_date TIMESTAMP NOT NULL,
     end_date TIMESTAMP NOT NULL,
     name VARCHAR(100),
     product_id BIGINT NOT NULL,
     priority INT NOT NULL,
     price DECIMAL(10,2) NOT NULL,
     curr VARCHAR(3) NOT NULL,
     CONSTRAINT fk_price_brand FOREIGN KEY (brand_id) REFERENCES brand(id),
     CONSTRAINT fk_price_product FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE INDEX idx_price_id ON price (id);

CREATE INDEX idx_price_brand_id ON price (brand_id);
CREATE INDEX idx_price_product_id ON price (product_id);


