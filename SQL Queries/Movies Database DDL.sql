 -- Initialise Database 
drop database if exists movies;
create database movies;
use movies;

-- Create tables in Database
create table genre (
	GenreID int not null,
    GenreName varchar(30) not null,
	primary key (GenreID)
);

create table director (
	DirectorID int not null,
	FirstName varchar(30) not null,
	LastName varchar(30) not null,
	BirthDate date,
	primary key (DirectorID)
);

create table rating (
	RatingID int not null,
    RatingName char(5) not null,
    primary key (RatingID)
);

create table actor (
	ActorID int not null,
	FirstName varchar(30) not null,
	LastName varchar(30) not null,
	BirthDate date,
	primary key (ActorID)
);

create table movie (
	MovieID int not null,
	GenreID int not null,
	DirectorID int,
	RatingID int,
	Title varchar(128) not null,
	ReleaseDate date,
    primary key (MovieID),
    foreign key (GenreID) references genre (GenreID),
    foreign key (DirectorID) references director (DirectorID),
    foreign key (RatingID) references rating (RatingID)
);

create table castmembers (
	CastMemberID int not null,
	ActorID int not null,
	MovieID int not null,
	Role varchar(50) not null,
	primary key (CastMemberID),
    foreign key (ActorID) references actor (ActorID),
    foreign key (MovieID) references movie (MovieID)
);

-- Show Database
show tables;
describe movie;
describe director;
describe castmembers;