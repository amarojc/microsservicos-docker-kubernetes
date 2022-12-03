update shopping.shop  set total =
(select SUM(price) 
 from shopping.item item
 where shopping.shop.id = item.shop_id
 );