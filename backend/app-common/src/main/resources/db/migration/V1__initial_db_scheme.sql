create table if not exists category
(
    id          bigserial    not null
    constraint category_pkey
    primary key,
    category_id uuid         not null
    constraint uk_op35ifsyq39mxtmfs1asvbltv
    unique,
    created_at  timestamp,
    name        varchar(255) not null,
    updated_at  timestamp
    );

create table if not exists color
(
    id         bigserial    not null
    constraint color_pkey
    primary key,
    color_id   uuid         not null
    constraint uk_g4852u9an5u4f1cj1jxpypgee
    unique,
    created_at timestamp,
    hex        bytea        not null,
    name       varchar(255) not null,
    updated_at timestamp
    );

create table if not exists "order"
(
    id           bigserial    not null
    constraint order_pkey
    primary key,
    order_id     uuid         not null
    constraint uk_iyd3du1hn587q5c1gjfw9ksgq
    unique,
    order_number varchar(255) not null
    constraint uk_c19ayt4j75vpp3slm1gitc22v
    unique
    );

create table if not exists product
(
    id          bigserial    not null
    constraint product_pkey
    primary key,
    created_at  timestamp,
    currency    varchar(255) not null,
    description varchar(255) not null,
    name        varchar(255) not null,
    price       bigint       not null,
    product_id  uuid         not null
    constraint uk_at03k6o77o1rru4e6jtn4vbx7
    unique,
    style_code  varchar(255) not null,
    updated_at  timestamp
    );

create table if not exists product_sku
(
    id         bigserial    not null
    constraint product_sku_pkey
    primary key,
    created_at timestamp,
    quantity   bigint       not null,
    size       varchar(255) not null,
    sku_id     uuid         not null
    constraint uk_aw0amajcudfm7bs3mc70cpl63
    unique,
    updated_at timestamp,
    product_id bigint
    constraint fklh9qu0pcf5622eexwh1lmc157
    references product
    );

create table if not exists "user"
(
    id         bigserial    not null
    constraint user_pkey
    primary key,
    created_at timestamp,
    email      varchar(255) not null
    constraint uk_ob8kqyqqgmefl0aco34akdtpe
    unique,
    full_name  varchar(255) not null,
    password   varchar(255) not null,
    phone_num  varchar(15)  not null,
    updated_at timestamp,
    user_id    uuid         not null
    constraint uk_a3imlf41l37utmxiquukk8ajc
    unique
    );

create table if not exists address
(
    id                 bigserial    not null
    constraint address_pkey
    primary key,
    address1           varchar(255) not null,
    address2           varchar(255) not null,
    address_id         uuid         not null
    constraint uk_scpdoha0q1mmbp5f9lojr3s9x
    unique,
    created_at         timestamp,
    postal_code        varchar(255) not null,
    receiver_email     varchar(255) not null,
    receiver_name      varchar(255) not null,
    receiver_phone_num varchar(255) not null,
    updated_at         timestamp,
    user_id            bigint
    constraint fkibojxnhlre8lcn6ag9a35epr1
    references "user"
    );

create table if not exists cart
(
    id         bigserial not null
    constraint cart_pkey
    primary key,
    cart_id    uuid      not null
    constraint uk_hmtug6lso2eoen6whdd1jyiqt
    unique,
    created_at timestamp,
    updated_at timestamp,
    user_id    bigint
    constraint fkaf0wt8hgkk8v5rfpwdwq7se0t
    references "user"
);

create table if not exists cart_item
(
    id         bigserial not null
    constraint cart_item_pkey
    primary key,
    created_at timestamp,
    quantity   bigint,
    updated_at timestamp,
    cart_id    bigint
    constraint fk1uobyhgl1wvgt1jpccia8xxs3
    references cart,
    sku_id     bigint
    constraint fkb6h5alyxo2apt5uhto1tc6oai
    references product_sku
);

