 -- Initialise Database 
drop database if exists books;
create database books;
use books;

-- Create tables in Database
create table book (
	BookID int not null,
    Title varchar(100) not null,
    PublicationDate datetime,
    primary key (BookID)
);

create table author (
	AuthorID int not null,
	FirstName varchar(25) not null,
	MiddleName varchar(25),
	LastName varchar(50) not null,
	Gender char(1),
	DateOfBirth datetime not null,
	DateOfDeath datetime,
    primary key (AuthorID)
);

create table authorbook (
	BookID int not null,
	AuthorID int not null,
	foreign key (BookID) references book (BookID),
	foreign key (AuthorID) references author (AuthorID)
);

create table format (
	FormatID int not null,
	FormatName varchar(12) not null,
    primary key (FormatID)
);

create table bookformat (
	BookID int not null,
	FormatID int not null,
    Price double,
	QuantityOnHand int,    
	foreign key (BookID) references book (BookID),
	foreign key (FormatID) references format (FormatID)
);

create table genre (
	GenreID int not null,
    GenreName varchar(25) not null,
	primary key (GenreID)
);

create table bookgenre (
	BookID int not null,
	GenreID int not null,
	foreign key (BookID) references book (BookID),
	foreign key (GenreID) references genre (GenreID)
);

-- Show Database
show tables;
describe book;
describe author;
describe bookformat;