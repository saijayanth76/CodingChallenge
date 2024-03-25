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

INSERT INTO User (userId, username, password, role)
VALUES
(1, 'admin_user', 'admin@123', 'Admin'),
(2, 'john_doe', 'password123', 'User'),
(3, 'jane_smith', 'pass456', 'User'),
(4, 'test_user', 'testpass', 'User'),
(5, 'demo_user', 'demopass', 'User');

INSERT INTO Product (productId, productName, description, price, quantityStock, type)
VALUES
(1, 'Laptop', 'High-performance laptop with SSD storage', 1200.00, 10, 'Electronics'),
(2, 'T-shirt', 'Cotton t-shirt for everyday wear', 25.00, 50, 'Clothing'),
(3, 'Smartphone', 'Latest smartphone with dual camera', 800.00, 15, 'Electronics'),
(4, 'Jeans', 'Slim-fit jeans for men', 45.00, 30, 'Clothing'),
(5, 'Headphones', 'Wireless headphones with noise cancellation', 150.00, 20, 'Electronics');

INSERT INTO Electronics (productId, brand, warrantyPeriod)
VALUES
(1, 'Dell', 24),
(3, 'Apple', 12),
(5, 'Sony', 18);

INSERT INTO Clothing (productId, size, color)
VALUES
(2, 'M', 'Blue'),
(4, 'L', 'Black');

