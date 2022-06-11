create table items
(
    item_id integer not null,
    item_name varchar(100) not null,
    price float default 0,
    sale_price float default 0,
    item_image varchar(50),
    desc_image varchar(50),
    item_desc varchar(500),
    parent_id integer,
    p_group_name varchar(50),
    limit_qty int,
    primary key(item_id)
);

create table options
(
    option_id integer not null,
    item_id integer,
    option_name varchar(100) not null,
    price float default 0,
    primary key(option_id),
    foreign key (item_id) references items(item_id)
);


create table users
(
    user_id varchar(30) not null,
    user_pw varchar(30) not null,
    user_name varchar(30) not null,
    address1 varchar(100),
    address2 varchar(100),
    point integer default 0,
    primary key(user_id)
);


create table orders
(
    order_id integer not null,
    user_id integer not null,
    order_date date not null,
    use_point integer default 0,
    use_coupon integer default 0,
    new_point integer default 0,
    status integer, -- 기준정보 테이블 코드로 관리 (status)
    use_card boolean,
    v_account varchar(20), -- 입금받을 가상계좌
    primary key(order_id),
    foreign key (user_id) references users(user_id)
);

create table order_items
(
    item_seq integer not null,
    order_id integer not null,
    item_id integer not null,
    option_id integer not null,
    qty integer default 1,
    primary key(item_seq),
    foreign key (order_id) references orders(order_id),
    foreign key (item_id) references items(item_id),
    foreign key (option_id) references options(option_id)
);