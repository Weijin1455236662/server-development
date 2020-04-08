drop table if exists customer;
drop table if exists cargo;

create table customer (
  id identity,
  name varchar(25) not null,
  address varchar(50) not null,
  city varchar(20) not null,
  email varchar(30) not null
);

create table cargo (
  id integer identity primary key,
  customer integer not null,
  product varchar(50) not null,
  quantity integer not null,
  orderDate datetime not null,
  foreign key (customer) references customer(id)
);
