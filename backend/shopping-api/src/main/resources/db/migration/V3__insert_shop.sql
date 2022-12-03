/*
1º É realizado o insert na tabela shop com o valor total da compra zerada;
2º Em seguida é realizado o insert dos itens no último shop inserido, buscando 
na tabela product o preço de cada item.
*/
INSERT INTO shopping.shop (user_identifier, date, total) VALUES ('321', NOW(), 0);
INSERT INTO shopping.item (product_identifier, price, shop_id) VALUES 
('ps4-500gb', (select DISTINCT preco from products.product where product_identifier = 'ps4-500gb'),(select currval('shopping.shop_id_seq'))),
('smart-tv-lg-50', (select DISTINCT preco from products.product where product_identifier = 'smart-tv-lg-50'), (select currval('shopping.shop_id_seq'))),
('pista-hotwheels', (select DISTINCT preco from products.product where product_identifier = 'pista-hotwheels'),(select currval('shopping.shop_id_seq')));
/************/
INSERT INTO shopping.shop (user_identifier, date, total) VALUES ('123', NOW(), 0);
INSERT INTO shopping.item (product_identifier, price, shop_id) VALUES 
('notebook-dell-i9', (select DISTINCT preco from products.product where product_identifier = 'notebook-dell-i9'),(select currval('shopping.shop_id_seq'))),
('smart-tv-samsung-55', (select DISTINCT preco from products.product where product_identifier = 'smart-tv-samsung-55'), (select currval('shopping.shop_id_seq'))),
('ps5-fifa-2023', (select DISTINCT preco from products.product where product_identifier = 'ps5-fifa-2023'),(select currval('shopping.shop_id_seq'))),
('carro-f1', (select DISTINCT preco from products.product where product_identifier = 'carro-f1'),(select currval('shopping.shop_id_seq')));
/************/
INSERT INTO shopping.shop (user_identifier, date, total) VALUES ('321', NOW(), 0);
INSERT INTO shopping.item (product_identifier, price, shop_id) VALUES 
('ps4-500gb', (select DISTINCT preco from products.product where product_identifier = 'ps4-500gb'),(select currval('shopping.shop_id_seq'))),
('smart-tv-lg-50', (select DISTINCT preco from products.product where product_identifier = 'smart-tv-lg-50'), (select currval('shopping.shop_id_seq'))),
('pista-hotwheels', (select DISTINCT preco from products.product where product_identifier = 'pista-hotwheels'),(select currval('shopping.shop_id_seq')));
/************/
INSERT INTO shopping.shop (user_identifier, date, total) VALUES ('123', NOW(), 0);
INSERT INTO shopping.item (product_identifier, price, shop_id) VALUES 
('smart-tv-lg-50', (select DISTINCT preco from products.product where product_identifier = 'smart-tv-lg-50'),(select currval('shopping.shop_id_seq'))),
('ps4-1tb', (select DISTINCT preco from products.product where product_identifier = 'ps4-1tb'),(select currval('shopping.shop_id_seq'))),
('carro-f1', (select DISTINCT preco from products.product where product_identifier = 'carro-f1'),(select currval('shopping.shop_id_seq')));
/************/
INSERT INTO shopping.shop (user_identifier, date, total) VALUES ('321', NOW(), 0);
INSERT INTO shopping.item (product_identifier, price, shop_id) VALUES 
('ps4-500gb', (select DISTINCT preco from products.product where product_identifier = 'ps4-500gb'),(select currval('shopping.shop_id_seq'))),
('smart-tv-samsung-55', (select DISTINCT preco from products.product where product_identifier = 'smart-tv-samsung-55'), (select currval('shopping.shop_id_seq'))),
('notebook-dell-g-series', (select DISTINCT preco from products.product where product_identifier = 'notebook-dell-g-series'),(select currval('shopping.shop_id_seq')));
INSERT INTO shopping.shop (user_identifier, date, total) VALUES ('123', NOW(), 0);
INSERT INTO shopping.item (product_identifier, price, shop_id) VALUES 
('notebook-dell-i5', (select DISTINCT preco from products.product where product_identifier = 'notebook-dell-i5'),(select currval('shopping.shop_id_seq'))),
('smart-tv-samsung-42', (select DISTINCT preco from products.product where product_identifier = 'smart-tv-samsung-42'), (select currval('shopping.shop_id_seq'))),
('ps5-fifa-2023', (select DISTINCT preco from products.product where product_identifier = 'ps5-fifa-2023'),(select currval('shopping.shop_id_seq'))),
('carro-f1', (select DISTINCT preco from products.product where product_identifier = 'carro-f1'),(select currval('shopping.shop_id_seq'))),
('pista-hotwheels', (select DISTINCT preco from products.product where product_identifier = 'pista-hotwheels'),(select currval('shopping.shop_id_seq'))),
('smart-tv-samsung-55', (select DISTINCT preco from products.product where product_identifier = 'smart-tv-samsung-55'),(select currval('shopping.shop_id_seq')));