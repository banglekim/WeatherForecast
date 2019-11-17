create database weatherforecast;
use weatherforecast;
create table user(userid int auto_increment primary key, username varchar(45) not null unique, password varchar(256) not null);
insert into user(username,password) values("user","$2y$10$yHtsAzo.SHVHs.oNSYWSQuSK9ObEAeSoOy.PO4/2M3ML.qVfqa4Iu"); 
insert into user(username,password) values("admin","$2y$10$yHtsAzo.SHVHs.oNSYWSQuSK9ObEAeSoOy.PO4/2M3ML.qVfqa4Iu"); 
select * from user;
create table user_auth_group(
id int auto_increment primary key, username varchar(45) not null, 
auth_group varchar(45) not null, constraint user_auth_user_group_fk foreign key (username) references user(username),
unique(username,auth_group));
insert into user_auth_group(username,auth_group) values ("user","USER");
insert into user_auth_group(username,auth_group) values ("admin","USER");
insert into user_auth_group(username,auth_group) values ("admin","ADMIN");
select * from user_auth_group;
