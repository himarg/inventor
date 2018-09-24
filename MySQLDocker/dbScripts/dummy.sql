CREATE TABLE manufacturer (
  mfr_id bigint(20) NOT NULL PRIMARY KEY,
  name varchar(255) DEFAULT NULL
);

CREATE TABLE unit_of_measure (
  id bigint(20) NOT NULL PRIMARY KEY,
  unit_name varchar(255) DEFAULT NULL
);

CREATE TABLE stock_item (
  stock_item_id bigint(20) NOT NULL,
  expiry_date date DEFAULT NULL,
  last_updated_date datetime DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  packing_size int(11) NOT NULL,
  quantity_in_stock float NOT NULL,
  uom_id bigint(20) DEFAULT NULL,
  mfr_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (stock_item_id),
  KEY FKmmy61qs1ybv4y10kx65vbotc7 (uom_id),
  KEY FK4di8lq5r4xav6fifd2mpi9amg (mfr_id)
)