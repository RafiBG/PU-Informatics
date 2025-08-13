--1.Създаване на обектите от схемата.
create database pizariaRafi

use pizariaRafi

create table Pizzas
(
pizza_id int primary key not null,
pizza_type varchar(20)

)

create table Clients
(
client_id int primary key not null,
name varchar(30),
phone varchar(10)
)

create table Pizza_Orders
(
pizza_id int not null foreign key references Pizzas(pizza_id),
client_id int not null foreign key references Clients(client_id)
primary key (pizza_id,client_id),
quantity int,
size char(1) check (size in('s','b')),
datetime datetime
)

--2.Добавяне на атрибут PRICE от тип decimal(5,2) за цена в 
--таблица PIZZA_ORDERS с ограничение на стойностите само положителни числа.
alter table Pizza_Orders
add price decimal(5,2) check(price > 0)

select * from Pizza_Orders

--3.Изтрий атрибут PHONE от таблица CLIENTS.
alter table Clients
drop column phone

select * from Clients
--4.Добавяне по един запис с произволни данни във всяка таблица. (или повече)

insert into Pizzas
values (1,'pizza 1')

insert into Clients
values (1,'Rafi')

insert into Pizza_Orders
values (1,1,10,'s',getdate(),45), (2,2,14,'b','2024-01-17',45)

select * from Pizzas
select * from Clients
select * from Pizza_Orders

--5. Промени количеството поръчана пица 
--на 5 и размера на малка за първият
--въведен идентификатор на пица.
update Pizza_Orders
set quantity = 5, size = 's'
where pizza_id = 1

--6. Вече не се предлага пица с последният идентификатор,
--   който сте попълнили – изтрийте я.
delete from Pizza_Orders
where pizza_id = 1

delete from Pizzas
where pizza_id = 1

--7. Изведи от името на кои клиенти и кога са направени поръчки на
--   малки пици. Подреди ги по име на клиент в низходящ ред.

--8 Добави нов клиент, без да добавяш поръчка за него.
insert into Clients
values (3,'Fero')


