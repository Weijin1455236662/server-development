create table address_book (
	id identity,
	name varchar(20) unique not null,
	address varchar(100) not null,
	zip_code varchar(6) not null,
	phone varchar(11) not null
);
