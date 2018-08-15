create database zufang;

use zufang;
--�û���
create table USERS
(
  ID        int primary key auto_increment,        
  NAME      VARCHAR(50),          
  PASSWORD  VARCHAR(50),          
  TELEPHONE VARCHAR(15),        
  USERNAME  VARCHAR(50),          
  ISADMIN   VARCHAR(5)             
);
--������
create table DISTRICT
(
  ID   int primary key,          
  NAME VARCHAR(50) 
);
--�ֵ���
create table STREET
(
  ID        int primary key,      
  NAME        VARCHAR(50),        
  DISTRICT_ID int               
);


--�������ͱ�
create table housetype
(
  ID    int primary key auto_increment,            
  NAME VARCHAR(20) 
);
--������Ϣ��
create table HOUSE
(
  ID          int primary key auto_increment,                
  USER_ID     int,                
  TYPE_ID     int,                 
  TITLE       NVARCHAR(50),    --nvarchar      
  DESCRIPTION text,     
  PRICE       double, 
  PUBDATE     DATE,                  
  FLOORAGE    int,                 
  CONTACT     VARCHAR(100), 
  STREET_ID   int                 
);

select * from house;
select * from DISTRICT;

select * from STREET;
select * from housetype;
select * from USERS;


delete from house;

