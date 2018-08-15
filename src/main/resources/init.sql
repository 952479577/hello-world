
insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);


insert into housetype ( NAME)
values ('一室一厅');
insert into housetype ( NAME)
values ('一室两厅');
insert into housetype ( NAME)
values ( '两室一厅');
insert into housetype ( NAME)
values ( '两室两厅');
insert into housetype ( NAME)
values ('三室一厅');
insert into housetype ( NAME)
values ( '三室两厅');
insert into housetype (NAME)
values ( '四室一厅');
insert into housetype ( NAME)
values ( '四室两厅');
insert into housetype ( NAME)
values ( '四十三厅');

insert into HOUSE(USER_ID,TYPE_ID,TITLE,DESCRIPTION,PRICE,PUBDATE,FLOORAGE,STREET_ID) 
values(1,1,'第一个','sdadas',200,now(),1,'sdasd',1);
);

insert into USERS ( NAME,password,telephone,username,isadmin)
values ( 'yc','a','1234433','a','1');

select * from users;

select id,name from district;
select count(1) from users where username='a';
select * from users where username='a' and password='a'
select * from users where id=1;
