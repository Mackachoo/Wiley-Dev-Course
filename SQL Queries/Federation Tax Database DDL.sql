 -- Initialise Database 
drop database if exists federationtax;
create database federationtax;
use federationtax;

-- Create tables in Database
create table celestials (
	CelestialID int not null,
    Name varchar(100),
    Type varchar(10) not null,
    Subtype varchar(10),
    TaxRate float not null,
	primary key (CelestialID)
);

create table orbits (
	Body int not null,
    Satelite int not null,
    foreign key (Body) references celestials (CelestialID),
    foreign key (Satelite) references celestials (CelestialID)
);

create table aliens (
	AlienID int not null,
    Name varchar(100) not null,
    Origin int not null,
    TaxModifier float not null,
    primary key (AlienID),
    foreign key (Origin) references celestials (CelestialID)
);

create table populations (
	Alien int not null,
    Celestial int not null,
    Population decimal(12, 1) not null,
    foreign key (Alien) references aliens (AlienID),
    foreign key (Celestial) references celestials (CelestialID)
);

-- Show Database
show tables;
describe celestials;
describe aliens;
describe populations;