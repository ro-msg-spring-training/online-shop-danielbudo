CREATE TABLE Product_Category (
                                  id integer,
                                  name varchar(256),
                                  description varchar(256)
);

CREATE TABLE Product (
                         id integer,
                         name varchar(256),
                         description varchar(256),
                         price decimal(20, 2),
                         weight double,
                         category_id integer,
                         supplier_id integer,
                         image_url varchar(256)
);

CREATE TABLE Supplier(
                         id integer,
                         name varchar(256)
);

CREATE TABLE Stock(
                      product_id integer,
                      location_id integer,
                      quantity integer
);

CREATE TABLE OrderDetail(
                            order_id integer,
                            product_id integer,
                            quantity integer
);

CREATE TABLE Customer_Order(
                               id integer,
                               shippedFrom_id integer,
                               customer_id integer,
                               created_at datetime,
                               country varchar(60),
                               city varchar(60),
                               county varchar(60),
                               street_address varchar(256)
);

CREATE TABLE Location(
                         id integer,
                         name varchar(60),
                         country varchar(60),
                         city varchar(60),
                         county varchar(60),
                         street_address varchar(256)
);

CREATE TABLE Revenue(
                        id integer,
                        location_id integer,
                        date datetime,
                        sum decimal(20, 2)
);

CREATE TABLE Customer(
                         id integer,
                         firstName varchar(256),
                         lastName varchar(256),
                         username varchar(256),
                         password varchar(1024),
                         email_address varchar(256)
);