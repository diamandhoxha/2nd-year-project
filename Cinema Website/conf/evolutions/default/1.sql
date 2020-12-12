# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table basket (
  id                            bigint auto_increment not null,
  customer_email                varchar(255),
  constraint uq_basket_customer_email unique (customer_email),
  constraint pk_basket primary key (id)
);

create table category (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  constraint pk_category primary key (id)
);

create table category_movie (
  category_id                   bigint not null,
  movie_id                      bigint not null,
  constraint pk_category_movie primary key (category_id,movie_id)
);

create table category1 (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  constraint pk_category1 primary key (id)
);

create table category1_coming_soon_movie (
  category1_id                  bigint not null,
  coming_soon_movie_id          bigint not null,
  constraint pk_category1_coming_soon_movie primary key (category1_id,coming_soon_movie_id)
);

create table category2 (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_category2 primary key (id)
);

create table category3 (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_category3 primary key (id)
);

create table coming_soon_movie (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  description                   varchar(255),
  constraint pk_coming_soon_movie primary key (id)
);

create table food (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  size                          varchar(255),
  price                         double not null,
  category2_id                  bigint,
  constraint pk_food primary key (id)
);

create table merchandise_on_sale (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  stock                         integer not null,
  price                         double not null,
  category3_id                  bigint,
  constraint pk_merchandise_on_sale primary key (id)
);

create table movie (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  description                   varchar(255),
  screen                        integer not null,
  seats                         integer not null,
  price                         double not null,
  constraint pk_movie primary key (id)
);

create table order_item (
  id                            bigint auto_increment not null,
  order_id                      bigint,
  basket_id                     bigint,
  item_id                       bigint,
  quantity                      integer not null,
  price                         double not null,
  constraint pk_order_item primary key (id)
);

create table shop_order (
  id                            bigint auto_increment not null,
  order_date                    timestamp,
  customer_email                varchar(255),
  constraint pk_shop_order primary key (id)
);

create table showing (
  id                            bigint auto_increment not null,
  date                          date,
  time                          double not null,
  tickets                       integer not null,
  price                         double not null,
  movie_id                      bigint,
  constraint pk_showing primary key (id)
);

create table user (
  type                          varchar(31) not null,
  email                         varchar(255) not null,
  date_of_birth                 date,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  street1                       varchar(255),
  street2                       varchar(255),
  town                          varchar(255),
  post_code                     varchar(255),
  credit_card                   varchar(255),
  constraint pk_user primary key (email)
);

alter table basket add constraint fk_basket_customer_email foreign key (customer_email) references user (email) on delete restrict on update restrict;

alter table category_movie add constraint fk_category_movie_category foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_category_movie_category on category_movie (category_id);

alter table category_movie add constraint fk_category_movie_movie foreign key (movie_id) references movie (id) on delete restrict on update restrict;
create index ix_category_movie_movie on category_movie (movie_id);

alter table category1_coming_soon_movie add constraint fk_category1_coming_soon_movie_category1 foreign key (category1_id) references category1 (id) on delete restrict on update restrict;
create index ix_category1_coming_soon_movie_category1 on category1_coming_soon_movie (category1_id);

alter table category1_coming_soon_movie add constraint fk_category1_coming_soon_movie_coming_soon_movie foreign key (coming_soon_movie_id) references coming_soon_movie (id) on delete restrict on update restrict;
create index ix_category1_coming_soon_movie_coming_soon_movie on category1_coming_soon_movie (coming_soon_movie_id);

alter table food add constraint fk_food_category2_id foreign key (category2_id) references category2 (id) on delete restrict on update restrict;
create index ix_food_category2_id on food (category2_id);

alter table merchandise_on_sale add constraint fk_merchandise_on_sale_category3_id foreign key (category3_id) references category3 (id) on delete restrict on update restrict;
create index ix_merchandise_on_sale_category3_id on merchandise_on_sale (category3_id);

alter table order_item add constraint fk_order_item_order_id foreign key (order_id) references shop_order (id) on delete restrict on update restrict;
create index ix_order_item_order_id on order_item (order_id);

alter table order_item add constraint fk_order_item_basket_id foreign key (basket_id) references basket (id) on delete restrict on update restrict;
create index ix_order_item_basket_id on order_item (basket_id);

alter table order_item add constraint fk_order_item_item_id foreign key (item_id) references showing (id) on delete restrict on update restrict;
create index ix_order_item_item_id on order_item (item_id);

alter table shop_order add constraint fk_shop_order_customer_email foreign key (customer_email) references user (email) on delete restrict on update restrict;
create index ix_shop_order_customer_email on shop_order (customer_email);

alter table showing add constraint fk_showing_movie_id foreign key (movie_id) references movie (id) on delete restrict on update restrict;
create index ix_showing_movie_id on showing (movie_id);


# --- !Downs

alter table basket drop constraint if exists fk_basket_customer_email;

alter table category_movie drop constraint if exists fk_category_movie_category;
drop index if exists ix_category_movie_category;

alter table category_movie drop constraint if exists fk_category_movie_movie;
drop index if exists ix_category_movie_movie;

alter table category1_coming_soon_movie drop constraint if exists fk_category1_coming_soon_movie_category1;
drop index if exists ix_category1_coming_soon_movie_category1;

alter table category1_coming_soon_movie drop constraint if exists fk_category1_coming_soon_movie_coming_soon_movie;
drop index if exists ix_category1_coming_soon_movie_coming_soon_movie;

alter table food drop constraint if exists fk_food_category2_id;
drop index if exists ix_food_category2_id;

alter table merchandise_on_sale drop constraint if exists fk_merchandise_on_sale_category3_id;
drop index if exists ix_merchandise_on_sale_category3_id;

alter table order_item drop constraint if exists fk_order_item_order_id;
drop index if exists ix_order_item_order_id;

alter table order_item drop constraint if exists fk_order_item_basket_id;
drop index if exists ix_order_item_basket_id;

alter table order_item drop constraint if exists fk_order_item_item_id;
drop index if exists ix_order_item_item_id;

alter table shop_order drop constraint if exists fk_shop_order_customer_email;
drop index if exists ix_shop_order_customer_email;

alter table showing drop constraint if exists fk_showing_movie_id;
drop index if exists ix_showing_movie_id;

drop table if exists basket;

drop table if exists category;

drop table if exists category_movie;

drop table if exists category1;

drop table if exists category1_coming_soon_movie;

drop table if exists category2;

drop table if exists category3;

drop table if exists coming_soon_movie;

drop table if exists food;

drop table if exists merchandise_on_sale;

drop table if exists movie;

drop table if exists order_item;

drop table if exists shop_order;

drop table if exists showing;

drop table if exists user;

