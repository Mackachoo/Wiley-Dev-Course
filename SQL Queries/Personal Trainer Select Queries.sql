use personaltrainer;

-- 1) Select all rows and columns from the Exercise table. (64 rows)
select * from exercise;

-- 2) Select all rows and columns from the Client table. (500 rows)
select * from client;

-- 3) Select all columns from Client where the City is Metairie. (29 rows)
select * from client where City = 'Metairie';

-- 4) Is there a Client with the ClientId '818u7faf-7b4b-48a2-bf12-7a26c92de20c'? (0 rows)
select count(firstName)
from client
where
    ClientId = '818u7faf-7b4b-48a2-bf12-7a26c92de20c';

-- 5) How many rows are in the Goal table? (17 rows)
select count(*) from goal;

-- 6) Select Name and LevelId from the Workout table. (26 rows)
select Name, LevelId from workout;

-- 7) Select Name, LevelId, and Notes from Workout where LevelId is 2. (11 rows)
select Name, LevelId, Notes from workout where LevelId = 2;

-- 8) Select FirstName, LastName, and City from Client where City is Metairie, Kenner, or Gretna. (77 rows)
select FirstName, LastName, City
from client
where
    City = 'Metairie'
    or City = 'Kenner'
    or City = 'Gretna';

-- 9) Select FirstName, LastName, and BirthDate from Client for Clients born in the 1980s. (72 rows)
select FirstName, LastName, BirthDate
from client
where
    BirthDate >= '1980-01-01'
    and BirthDate < '1990-01-01';

-- 10) Write the query above in a different way; if you used BETWEEN, you can't use it again or if you didn't use BETWEEN, use it!
select FirstName, LastName, BirthDate
from client
where
    BirthDate between '1980-01-01' and '1989-12-31';

-- 11) How many rows in the Login table have a .gov EmailAddress? (17 rows)
select count(*) from login where EmailAddress like '%.gov';

-- 12) How many Logins do NOT have a .com EmailAddress? (122 rows)
select count(*) from login where EmailAddress not like '%.com';

-- 13) Select first and last name of Clients without a BirthDate. (37 rows)
select FirstName, LastName from client where BirthDate is null;

-- 14) Select the Name of each ExerciseCategory that has a parent (ParentCategoryId value is not null). (12 rows)
select Name
from exercisecategory
where
    ParentCategoryId is not null;

-- 15) Select Name and Notes of each level 3 Workout that contains the word 'you' in its Notes. (4 rows)
select Name, Notes
from workout
where
    levelId = 3
    and Notes like '%you%';

-- 16) Select FirstName, LastName, City from Client whose LastName starts with L,M, or N and who live in LaPlace. (5 rows)
select FirstName, LastName, City
from client
where (
        LastName like 'L%'
        or LastName like 'M%'
        or LastName like 'N%'
    )
    and City = 'LaPlace';
-- 17) Select InvoiceId, Description, Price, Quantity, ServiceDate and the line item total, a calculated value, from InvoiceLineItem, where the line item total is between 15 and 25 dollars. (667 rows)
select
    InvoiceId,
    Description,
    Price,
    Quantity,
    ServiceDate,
    Price * Quantity as LineItemTotal
from InvoiceLineItem
where
    Price * Quantity between 15 and 25;

-- 18) Does the database include an email address for the Client, Estrella Bazely?
select ClientID
from client
where
    FirstName = 'Estrella'
    and LastName = 'Bazely';

select EmailAddress
from login
where
    ClientId = '87976c42-9226-4bc6-8b32-23a8cd7869a5';

-- 19) What are the Goals of the Workout with the Name 'This Is Parkour'?
select WorkoutId from workout where Name = 'This Is Parkour';

select GoalId from workoutgoal where WorkoutId = 12;

select Name from goal where GoalId = 3 or GoalId = 8 or GoalId = 15;