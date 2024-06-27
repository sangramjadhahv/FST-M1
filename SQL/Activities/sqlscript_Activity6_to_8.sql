REM   Script: Activity6_to_8
REM   Activity 6 to 8 covered

drop table orders;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

drop table orders;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

select distinct salesman_id from orders;

select order_no from orders order by order_date;

select order_no from orders order by purchase_amount desc;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;

select order_no, order_date from orders order by order_date;

select order_no, purchase_amount from orders order by purchase_amount desc;

select sum(purchase_amount) as "Total Purchase Amount" from orders group by purchase_amount;

select avg(purchase_amount) as "Total Purchase Amount" from orders group by purchase_amount;

select order_id, avg(purchase_amount) as "Average Purchase Amount" from orders group by purchase_amount;

select order_no, avg(purchase_amount) as "Average Purchase Amount" from orders group by purchase_amount;

select order_no, avg(purchase_amount) as "Average Purchase Amount" from orders;

select SUM(purchase_amount) as "Total Purchase Amount" from orders;

select avg(purchase_amount) as "Average Purchase Amount" from orders;

select max(purchase_amount) as "Maximum Purchase Amount" from orders;

select min(purchase_amount) as "Maximum Purchase Amount" from orders;

select count(salesman_id) as "Salesmen count" from orders;

select max(purchase_amount) as "Maximum Purchase Amount" from orders order by customer_id, "Maximum Purchase Amount";

select max(purchase_amount) as "Maximum Purchase Amount" from orders order by customer_id;

select customer_id, max(purchase_amount) as "Maximum Purchase Amount" from orders group by customer_id;

select salesman_id, max(purchase_amount) as "Maximum Purchase Amount" from orders where order_date = '2012-08-17' group by salesman_id;

select salesman_id, max(purchase_amount) as "Maximum Purchase Amount" from orders where order_date = '2012/08/17' group by salesman_id;

select salesman_id,order_date, max(purchase_amount) as "Maximum Purchase Amount" from orders where order_date = '2012/08/17' group by salesman_id, order_date;

select salesman_id,order_date, max(purchase_amount) as "Maximum Purchase Amount" from orders where order_date = to_date('2012/08/17', 'YYYY/MM/DD') group by salesman_id, order_date;

select customer_id, order_date, max(purchase_amount) as "Maximum Purchase Amount" from orders where max(purchase_amount) in (2030, 3450, 5760, 6000) group by customer_id, order_date;

select customer_id, order_date, max(purchase_amount) as "Maximum Purchase Amount" from orders group by customer_id, order_date having max(purchase_amount) in (2030, 3450, 5760, 6000);

drop table orders;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

select distinct salesman_id from orders;

select order_no, order_date from orders order by order_date;

select order_no, purchase_amount from orders order by purchase_amount desc;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;

select sum(purchase_amount) as "Total Purchase Amount" from orders;

select avg(purchase_amount) as "Average Purchase Amount" from orders;

select max(purchase_amount) as "Maximum Purchase Amount" from orders;

select min(purchase_amount) as "Maximum Purchase Amount" from orders;

select count(salesman_id) as "Salesmen count" from orders;

select customer_id, max(purchase_amount) as "Maximum Purchase Amount" from orders group by customer_id;

select salesman_id,order_date, max(purchase_amount) as "Maximum Purchase Amount" from orders where order_date = to_date('2012/08/17', 'YYYY/MM/DD') group by salesman_id, order_date;

select customer_id, order_date, max(purchase_amount) as "Maximum Purchase Amount" from orders group by customer_id, order_date having max(purchase_amount) in (2030, 3450, 5760, 6000);

