
insert into DISTRICT (ID, NAME)
values (1001, '����');
insert into DISTRICT (ID, NAME)
values (1002, '����');
insert into DISTRICT (ID, NAME)
values (1003, 'ʯ��ɽ');
insert into DISTRICT (ID, NAME)
values (1006, '����');
insert into DISTRICT (ID, NAME)
values (1000, '��̨');
insert into DISTRICT (ID, NAME)
values (1004, '����');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '֪��·', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '�йش���', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, 'ѧԺ·', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '����·', 1006);


insert into housetype ( NAME)
values ('һ��һ��');
insert into housetype ( NAME)
values ('һ������');
insert into housetype ( NAME)
values ( '����һ��');
insert into housetype ( NAME)
values ( '��������');
insert into housetype ( NAME)
values ('����һ��');
insert into housetype ( NAME)
values ( '��������');
insert into housetype (NAME)
values ( '����һ��');
insert into housetype ( NAME)
values ( '��������');
insert into housetype ( NAME)
values ( '��ʮ����');

insert into HOUSE(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,PUBDATE,FLOORAGE,STREET_ID) 
values(1,1,'��һ��','sdadas',200,now(),1,'sdasd',1);
);

insert into USERS ( NAME,password,telephone,username,isadmin)
values ( 'yc','a','1234433','a','1');

select * from users;

select id,name from district;
select count(1) from users where username='a';
select * from users where username='a' and password='a'
select * from users where id=1;
