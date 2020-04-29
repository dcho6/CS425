CREATE TABLE Model
(
	model_number int NOT NULL PRIMARY KEY,
	sale_price int,
	manufacturer varchar(25) NOT NULL
);
 CREATE INDEX modelNum_index on Model(model_number);
CREATE TABLE Customer
(
	customer_id char(9) NOT NULL PRIMARY KEY,
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NOT NULL,
	preference varchar(15),
	company varchar(25)
);
CREATE INDEX customerID_index on Customer(customer_id);
CREATE TABLE Employee
(
	ssn int NOT NULL UNIQUE CHECK (ssn > 0 AND ssn < 1000000000),
	employee_id char(9) NOT NULL UNIQUE,
	privilege_type varchar(15) CHECK (privilege_type in ('admin', 'sales', 'HR', 'engineer')),
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NOT NULL,
	password varchar(25),
	pay_type varchar(10) CHECK (pay_type in ('Hourly', 'Salary')),
	pay int,
	total_sales int,
	username varchar(25) NOT NULL UNIQUE,
	PRIMARY KEY (ssn, employee_id)
);

CREATE TABLE PurchaseOrder
(
	order_number int NOT NULL PRIMARY KEY,
	customer_id char(9) NOT NULL REFERENCES Customer(customer_id) ON DELETE CASCADE,
	employee_id char(9) NOT NULL REFERENCES Employee(employee_id) ON DELETE CASCADE,
	quantity int,
	sale_value int,
	UNIQUE (customer_id, employee_id)
);
CREATE INDEX purchaseOrderNum_index on PurchaseOrder(order_number);

CREATE TABLE Shipping
(
	tracking_number char(9) NOT NULL PRIMARY KEY,
	day_shipped varchar(10),
	shipping_address varchar(60), 
	shipping_company varchar(25),
	shipping_cost int
);
CREATE INDEX shippingTracking_index on Shipping(tracking_number);
CREATE TABLE Inventory
(
	model_number int NOT NULL REFERENCES Model(model_number) ON DELETE CASCADE,
	shelf_location varchar(25) NOT NULL,
	stock_quantity int,
	lead_time varchar(15),
	category_type varchar(25),
	PRIMARY KEY (model_number, shelf_location)
);

CREATE TABLE Login
(
	employee_id char(9) NOT NULL REFERENCES Employee(employee_id) ON DELETE CASCADE,
	ssn int NOT NULL REFERENCES Employee(ssn) ON DELETE CASCADE,
	username varchar(25) NOT NULL REFERENCES Employee(username) ON DELETE CASCADE,
	login_time varchar(10) NOT NULL,
	logout_time varchar(10) NOT NULL,
	privilege varchar(15),
	PRIMARY KEY (employee_id, ssn, username, login_time, logout_time)
);

CREATE TABLE Tracks
(
	order_number int NOT NULL REFERENCES PurchaseOrder(order_number) ON DELETE CASCADE,
	tracking_number char(9) NOT NULL REFERENCES Shipping(tracking_number) ON DELETE CASCADE,
	PRIMARY KEY (order_number, tracking_number)
);


CREATE INDEX employeeID_index on Employee(employee_id);

CREATE ROLE admin;

GRANT all privileges on Employee, Tracks, Login, Inventory, Shipping, PurchaseOrder, Customer, Model to admin;

Create view customer_details as(select customer_id, preference, company, order_number, employee_id, quantity, sale_value from Customer natural join PurchaseOrder);
 
Create Role Sales;

Grant select on customer_details to Sales;

Grant all privileges on purchaseorder, customer to Sales;

Create Role Engineer;

Grant all privileges on Model to Sales;
