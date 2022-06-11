-- 상품

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10001, '사각 접이식 캠핑 의자', 42000, 0, '10001-1.jpg', '10001-2.jpg',
        '', 10001, '', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10002, '가방 White', 2000, 0, '', '',
        '', 10001, '가방', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10003, '가방 Black', 2000, 0, '', '',
        '', 10001, '가방', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10004, '컵걸이 White', 1000, 0, '', '',
        '', 10001, '컵걸이', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10005, '컵걸이 Black', 1000, 0, '', '',
        '', 10001, '컵걸이', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10006, 'LED 캠핑 랜턴', 36000, 0, '10006-1.jpg', '10006-2.jpg',
        '부가기능	LED전구, 생활방수, 미끄럼방지, 충격방지, 충전식, 점멸', 10006, '', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10007, '2600mAh', 6000, 0, '', '',
        '', 10006, '배터리 선택', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10008, '3000mAh', 9000, 0, '', '',
        '', 10006, '배터리 선택', 0);

insert into items(item_id, item_name, price, sale_price, item_image, desc_image,
                  item_desc, parent_id, p_group_name, limit_qty)
values (10009, '휴대용 포충기', 17000, 0, '', '',
        '', 10006, '추가 캠핑용품', 0);
-- 옵션

insert into options(option_id, item_id, option_name, price)
values (10001, 10001, '다크 브라운', 0);

insert into options(option_id, item_id, option_name, price)
values (10002, 10001, '밀크 브라운', 0);

insert into options(option_id, item_id, option_name, price)
values (10003, 10001, '화이트 베이지', 0);

insert into options(option_id, item_id, option_name, price)
values (10004, 10006, '랜턴 21년형(배터리 미포함)', 0);