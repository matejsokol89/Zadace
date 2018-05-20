drop database if exists postolar;
create database postolar;
use postolar;

create table postolar(
sifra int not null auto_increment primary key,
ime varchar(50),
prezime varchar(50)
);

create table popravak(
sifra int not null auto_increment primary key,
cijena decimal(18,2) not null,
trajanje int not null,
postolar int not null,
segrt int 
);

create table obuca(
sifra int not null auto_increment primary key,
marka varchar(50),
vlasnik int not null

);

create table korisnik(
sifra int not null auto_increment primary key,
ime varchar(50),
prezime varchar(50)

);

create table segrt(
sifra int not null auto_increment primary key,
ime varchar(50),
prezime varchar(50)


);

create table obuca_popravak(
obuca int not null,
popravak int not null

);

alter table popravak add foreign key (postolar) references postolar(sifra);
alter table popravak add foreign key (segrt) references segrt(sifra);

alter table obuca add foreign key (vlasnik) references korisnik(sifra);

alter table obuca_popravak add foreign key (obuca) references obuca(sifra);
alter table obuca_popravak add foreign key (popravak) references popravak(sifra);


