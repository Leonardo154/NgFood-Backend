
-- Este script é executado automaticamente pelo Spring Boot para criar a estrutura do banco de dados. 

create sequence order_seq start 100 increment 1;

create table product (
    id_product int not null,
    category varchar(1000) not null,
    title varchar(1000) not null,
    price decimal(8, 2) not null,
    img varchar(1000) not null,
    constraint product_pk primary key (id_product)
);

create table t_order (
    id_order int not null,
    data_hour datetime not null,
    situation varchar(100) not null,
    constraint order_pk primary key (id_order)
);

create table item_order (
    id_order int not null,
    id_product int not null,
    quantity int not null,
    constraint item_order_pk primary key (id_order, id_product)
);

alter table item_order add constraint item_order_fk1 foreign key (id_order) references t_order(id_order) on delete cascade;
alter table item_order add constraint item_order_fk2 foreign key (id_product) references product(id_product) on delete restrict;