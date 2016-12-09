create table manager(
  id int(11) not null auto_increment,
  login varchar(64) null,
  roles VARCHAR (64)null,
  primary key(id)
);

insert into manager(login,roles) values ('tom','1,2,3');
insert into manager(login,roles) values ('jack','2,3');