/* Case Study
   Order Management System */
   
create database OrderManagementSystem;
use OrderManagementSystem;

create table Product
(
	productId int primary key auto_increment,
    productName varchar(100) not null,
    description varchar(200),
    price decimal(10,2) not null,
    quantityStock int not null,
    type enum('Electronics', 'Clothing')
);

create table User
(
	userId int primary key auto_increment,
    username varchar(100) unique not null,
    password varchar(150) not null,
    role enum('Admin','User')
);

create table Electronics (
    productId int primary key,
    brand varchar(150),
    warrantyPeriod int,
    foreign key (productId) references Product(productId)
);

create table Clothing (
    productId int primary key,
    size varchar(10),
    color varchar(50),
    foreign key (productId) references Product(productId)
);

create table Orders(
	orderId int primary key auto_increment,
    userId int,
    productId int,
    quantity int,
    totalCost decimal(10,2),
    orderDate DATE DEFAULT(current_date()),
    foreign key (userId) references User(userId),
    foreign key (productId) references Product(productId)
    
);
