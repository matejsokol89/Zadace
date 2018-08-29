drop database if exists NBA_STATS;

create database NBA_STATS default character set utf8;

#sipavanje
#c:\xampp\mysql\bin\mysql -uedunova -pedunova --default_character_set=utf8 < f:\skriptaj18.sql

use NBA_STATS;

create table nbateam(
id_team int not null primary key auto_increment,
name varchar(50) not null,
city varchar(50) not null
);

create table game(
id_game int not null primary key auto_increment,

dateofgame datetime,
hometeam int not null,
awayteam int not null
);


create table player(
id_player int not null primary key auto_increment,
firstname varchar(50) not null,
lastname varchar(50) not null,
yersnumber varchar(20) not null,
position  varchar(20) not null,
nbateam int not null
);


create table playerstats(
id_stats int not null primary key auto_increment,
gamesplayed decimal(18,2),
fg2ptatt decimal(18,2),
fg2ptmade decimal(18,2),
fg3ptatt decimal(18,2),
fg3ptmade decimal(18,2),
ftatt decimal(18,2),
ftmade decimal(18,2),
player int  not null,
game int not null
);



alter table player add foreign key (nbateam) references nbateam(id_team);
alter table playerstats add foreign key (player) references player(id_player);
alter table playerstats add foreign key (game) references game(id_game);
alter table game add foreign key (hometeam) references nbateam(id_team);
alter table game add foreign key (awayteam) references nbateam(id_team);



insert into nbateam(id_team,name,city) values
(null,'Huston Rockets',	'Huston'),
(null,'Oklahoma Thunders',	'Oklahoma');

insert into player(id_player,firstname,lastname,yersnumber,position,nbateam) values
(null,'James',	'Harden','13','G',1),
(null,'Russel', 'Westbrook','0','PG',2);

insert into game(id_game,dateofgame,hometeam,awayteam) values
(null,'2008-11-11',1,2),
(null,'2008-11-10',1,2);


insert into playerstats(id_stats,gamesplayed,fg2ptatt,fg2ptmade,fg3ptatt,fg3ptmade,ftatt,ftmade,player,game) values
(null,72,34,27,10,6,5,5,1,1),
(null,80,41,33,4,4,6,3,2,2);



