BEGIN;

  CREATE SCHEMA IF NOT EXISTS govtech_procurement_products;

  CREATE TABLE IF NOT EXISTS govtech_procurement_products.products (
    id BIGSERIAL,
    sku VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    category VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    weight NUMERIC(10, 2) NOT NULL,
    average_rating NUMERIC(2, 1) NOT NULL,
    review_count BIGINT NOT NULL,
    images JSONB NOT NULL,

    created_date BIGINT NOT NULL,
    last_modified_date BIGINT NOT NULL,

    PRIMARY KEY (id)
  );


  CREATE TABLE IF NOT EXISTS govtech_procurement_products.product_reviews (
      id BIGSERIAL,
      product_id BIGINT NOT NULL,
      comment VARCHAR(255) NOT NULL,
      rating NUMERIC(2, 1) NOT NULL,

      created_date BIGINT NOT NULL,
      last_modified_date BIGINT NOT NULL,


      PRIMARY KEY (id),
      FOREIGN KEY (product_Id) REFERENCES govtech_procurement_products.products (id)
        ON UPDATE CASCADE ON DELETE CASCADE
    );

    CREATE UNIQUE INDEX idx_sku
    ON govtech_procurement_products.products (sku);

    CREATE INDEX idx_product_id
    ON govtech_procurement_products.product_reviews (product_id);

COMMIT;