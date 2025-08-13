create database pizzaria

use pizzaria

create table pizzas
(
pizza_id int not null primary key,
pizza_type varchar(20) not null
)

create table clients
(
client_id int not null primary key,
name varchar(30) not null,
phone varchar(10) not null
)


create table pizza_orders
(
pizza_id int not null foreign key references pizzas /*(pizza_id)*/,
client_id int not null references clients, --inline
primary key(pizza_id,client_id),

--foreign key (pizza_id)
--references pizzas(pizza_id)   --ouofline

quantity int not null,
size char(1) not null check(size in('s','b')),
datetime datetime
)

--2. Добавяне на атрибут PRICE от тип decimal(5,2)
--за цена в таблица PIZZA_ORDERS с ограничение на
--стойностите само положителни числа.
alter table PIZZA_ORDERS
add PRICE decimal(5,2) check(PRICE >0)

--3. Изтрий атрибут PHONE от таблица CLIENTS.
alter table clients 
drop column PHONE

--4. Добавяне по един запис с произволни данни 
--във всяка таблица. (или повече)
insert into pizzas(pizza_id,pizza_type)
values(5, 'Маргарита 2'),
      (2, '4 Сирена'),
	  (3, 'БГ пица'),
	  (4, 'Американо')

insert into clients
(client_id, name)
values(100, 'Иван'),
(101, 'Ивана'),
(102, 'Митко'),
(103, 'Денис'),
(104, 'Пенка')

insert into pizza_orders
(pizza_id, client_id, quantity, size,
datetime,price)
values
(1, 100, 2, 'b', '2023-12-26', 10),
(1, 101, 5, 's', '2023-12-27', 13),
(2, 101, 1, 'b', getdate(), 15),
(3, 102, 1, 'b', '2023-12-28', 13),
(4, 104, 1, 'b', getdate(), 13)

select * from pizza_orders

--5. Промени количеството поръчана пица 
--на 5 и размера на малка за първият
--въведен идентификатор на пица.
update  pizza_orders
set quantity = 5, size = 's'
where pizza_id = 1

--6. Вече не се предлага пица с 
--последният идентификатор, който 
--сте попълнили – изтрийте я.
delete from pizza_orders
where pizza_id = 4

delete from pizzas
where pizza_id = 4

--7. Изведи от името на кои клиенти 
--и кога са направени поръчки на
--малки пици. Подреди ги по име на
--клиент в низходящ ред.
select c.name, po.datetime
from clients c join pizza_orders po
on c.client_id=po.client_id
where size = 's'
order by  c.name asc

--8. Добави нов клиент, без да 
--добавяш поръчка за него.
insert into clients
(client_id, name)
values(105, 'test')

--9. Изведи имената на клиентите 
--и колко пъти са поръчвали пица.
--В резултатния набор да се покажат и
--клиентите без поръчка.
select c.name , count(pizza_id)
from clients c left join pizza_orders po
on po.client_id = c.client_id
group by c.name

--10. Изведи типа и броя на поръчвани
--пици. Само ако са поръчвани в повече
--от една поръчки.

--1
select pizza_type, count(po.pizza_id) 
from pizzas p left join pizza_orders po
on p.pizza_id = po.pizza_id
group by  pizza_type, p.pizza_id
having count(po.pizza_id) >1

--2
select pizza_type, sum(po.quantity) 
from pizzas p join pizza_orders po
on p.pizza_id = po.pizza_id
group by  pizza_type, p.pizza_id
having count(po.pizza_id) >1

--11. Създай изглед за типа на пиците 
--и сумарната им стойност в поръчка
create view view1
as
select pizza_type, 
       sum(po.quantity*price) suma
from pizzas p join pizza_orders po
on p.pizza_id = po.pizza_id
group by pizza_type

select * from view1