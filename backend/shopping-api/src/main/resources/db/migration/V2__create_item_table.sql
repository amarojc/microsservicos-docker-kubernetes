create table shopping.item(
	product_identifier varchar(100) not null,
	price float not null,
	shop_id bigserial REFERENCES shopping.shop(id)
);