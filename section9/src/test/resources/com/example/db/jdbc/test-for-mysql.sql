DROP DATABASE IF EXISTS exampledb6;
CREATE DATABASE exampledb6 DEFAULT CHARACTER SET utf8;
USE exampledb6;

CREATE TABLE customer (
  id int AUTO_INCREMENT  PRIMARY KEY not null,
  name varchar(25) not null,
  address varchar(40) not null,
  city varchar(20) not null,
  email varchar(30) not null
)ENGINE=InnoDB;

create table cargo (
  id int AUTO_INCREMENT primary key,
  customer integer not null,
  product varchar(50) not null,
  quantity integer not null,
  orderDate datetime not null,
  foreign key (customer) references customer(id)
)ENGINE=InnoDB;

insert into Customer (name, address, city, email) values ('zhangsan', 'address1', 'nanjing', 'zhangsan@163.com');
insert into Customer (name, address, city, email) values ('lisi', 'address2', 'guangzhou', 'lisi@163.com');
insert into Customer (name, address, city, email) values ('wangwu', 'address3', 'shanghai', 'wangwu@163.com');
insert into Customer (name, address, city, email) values ('zhaoliu', 'address4', 'beijing', 'zhaoliu@163.com');

insert into Cargo (customer, product, quantity, orderDate) values (1, 'cargo1', 2, '2012-06-09 22:00:00');
insert into Cargo (customer, product, quantity, orderDate) values (1, 'cargo2', 2, '2012-06-09 22:10:00');
insert into Cargo (customer, product, quantity, orderDate) values (1, 'cargo3', 2, '2012-07-04 23:30:00');
insert into Cargo (customer, product, quantity, orderDate) values (2, 'cargo4', 2, '2012-03-25 12:15:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo5', 2, '2012-03-25 12:15:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo6', 2, '2012-03-25 12:25:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo7', 2, '2012-03-25 12:35:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo8', 2, '2012-03-25 12:45:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo9', 2, '2012-03-25 12:55:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo10', 2, '2012-03-25 13:05:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo11', 2, '2012-03-25 13:15:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo12', 2, '2012-03-25 13:25:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo13', 14, '2012-03-25 13:35:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo14', 2, '2012-03-25 13:45:00');
insert into Cargo (customer, product, quantity, orderDate) values (4, 'cargo15', 2, '2012-03-25 13:55:00');

commit;
