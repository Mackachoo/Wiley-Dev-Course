use personaltrainer;

-- 1) Use an aggregate to count the number of Clients.
select count(*) from client;

-- 2) Use an aggregate to count Client.BirthDate.
select count(BirthDate) from client;
-- Some birthdays are null so it is less

-- 3) Group Clients by City and count them.
select City, count(*) as ClientCount from client group by City;
-- 4) Calculate a total per invoice using only the InvoiceLineItem table.
select InvoiceId, round(sum(Price * Quantity), 2) as Total
from invoicelineitem
group by
    InvoiceId;

-- 5) Modify the previous query to only include totals greater than $500.00 and sort from lowest total to highest.
select InvoiceId, round(sum(Price * Quantity), 2) as Total
from invoicelineitem
group by
    InvoiceId
having
    sum(Price * Quantity) > 500
order by sum(Price * Quantity) asc;

-- 6) Calculate the average line item total, grouped by InvoiceLineItem.Description.
select Description, round(avg(Price * Quantity), 2) as AverageCost
from invoicelineitem
group by
    Description;

-- 7) Select ClientId, FirstName, and LastName from Client for clients who have paid over $1000 total.
select client.ClientId, client.FirstName, client.LastName, round(
        sum(
            invoicelineitem.Price * invoicelineitem.Quantity
        ), 2
    ) as Total
from
    client
    left join invoice on client.ClientId = invoice.ClientId
    left join invoicelineitem on invoice.InvoiceId = invoicelineitem.InvoiceId
where
    invoice.InvoiceStatus = 2
group by
    client.ClientId,
    client.FirstName,
    client.LastName
having
    sum(
        invoicelineitem.Price * invoicelineitem.Quantity
    ) > 1000
order by client.LastName, client.FirstName asc;

-- 8) Count exercises by category.
select exercisecategory.Name, count(exercise.ExerciseId)
from exercise
    join exercisecategory on exercise.ExerciseCategoryId = exercisecategory.ExerciseCategoryId
group by
    exercisecategory.Name
order by count(exercise.ExerciseId) desc;

-- 9) Select Exercise.Name along with the minimum, maximum, and average ExerciseInstance.Sets.
select
    exercise.Name,
    min(exerciseinstance.Sets) as MinSet,
    max(exerciseinstance.Sets) as MaxSet,
    round(avg(exerciseinstance.Sets), 1) as AverageSet
from exercise
    left join exerciseinstance on exercise.ExerciseId = exerciseinstance.ExerciseId
group by
    exercise.Name
order by exercise.Name;

-- 10) Find the minimum and maximum Client.BirthDate per Workout.
select
    workout.Name,
    min(client.BirthDate) as MinBirthDate,
    max(client.BirthDate) as MaxBirthDate
from
    workout
    join clientworkout on workout.WorkoutId = clientworkout.WorkoutId
    join client on clientworkout.ClientId = client.ClientId
group by
    workout.Name
order by workout.Name;

-- 11) Count client goals.
select client.FirstName, client.LastName, count(clientgoal.ClientId) as NumGoals
from client
    left join clientgoal on client.ClientId = clientgoal.ClientId
group by
    client.ClientId,
    client.FirstName,
    client.LastName;

-- 12) Select Exercise.Name, Unit.Name, and minimum and maximum ExerciseInstanceUnitValue.Value for all exercises with a configured ExerciseInstanceUnitValue.
select
    exercise.Name as ExerciseName,
    unit.Name as UnitName,
    min(
        exerciseinstanceunitvalue.Value
    ) as MinValue,
    max(
        exerciseinstanceunitvalue.Value
    ) as `MaxValue`
from
    exercise
    inner join exerciseinstance on exercise.ExerciseId = exerciseinstance.ExerciseId
    inner join exerciseinstanceunitvalue on exerciseinstance.ExerciseInstanceId = exerciseinstanceunitvalue.ExerciseInstanceId
    left join unit on exerciseinstanceunitvalue.UnitId = unit.UnitId
group by
    exercise.Name,
    unit.Name
order by exercise.Name, unit.Name;

-- 13) Modify the query above to include ExerciseCategory.Name.
select
    exercisecategory.Name as CategoryName,
    exercise.Name as ExerciseName,
    unit.Name as UnitName,
    min(
        exerciseinstanceunitvalue.Value
    ) as MinValue,
    max(
        exerciseinstanceunitvalue.Value
    ) as `MaxValue`
from
    exercise
    inner join exerciseinstance on exercise.ExerciseId = exerciseinstance.ExerciseId
    inner join exerciseinstanceunitvalue on exerciseinstance.ExerciseInstanceId = exerciseinstanceunitvalue.ExerciseInstanceId
    left join unit on exerciseinstanceunitvalue.UnitId = unit.UnitId
    left join exercisecategory on exercise.ExerciseCategoryId = exercisecategory.ExerciseCategoryId
group by
    exercisecategory.Name,
    exercise.Name,
    unit.Name
order by exercisecategory.Name, exercise.Name, unit.Name;

-- 14) Select the minimum and maximum age in years for each Level.
select level.Name, floor(
        min(
            DATEDIFF(CURDATE(), client.BirthDate) / 365
        )
    ) as MinAge, floor(
        max(
            DATEDIFF(CURDATE(), client.BirthDate) / 365
        )
    ) as MaxAge
from
    client
    left join clientworkout on client.ClientId = clientworkout.ClientId
    left join workout on clientworkout.WorkoutId = workout.WorkoutId
    left join level on workout.LevelId = level.LevelId
group by
    level.Name
order by level.Name;

-- 15) Count logins by email extension (.com, .net, .org, etc...).
select substring_index(login.EmailAddress, '.', -1) as EmailExtension, count(client.ClientId) as NumLogins
from client
    left join login on client.ClientId = login.ClientId
where
    substring_index(login.EmailAddress, '.', -1) is not null
group by
    substring_index(login.EmailAddress, '.', -1)
order by count(client.ClientId) desc;

-- 16) Select Client FirstName and LastName and Workout.Name for all workouts that match at least 2 of a client's goals.

select
    workout.Name as Workout,
    concat(
        client.FirstName, ' ', client.LastName
    ) as ClientName,
    count(goal.GoalId) as NumGoals
from
    client
    join clientgoal on client.ClientId = clientgoal.ClientId
    join goal on clientgoal.GoalId = goal.GoalId
    join workoutgoal on goal.GoalId = workoutgoal.GoalId
    join workout on workoutgoal.WorkoutId = workout.WorkoutId
group by
    client.ClientId,
    workout.WorkoutId
having
    count(goal.GoalId) >= 2
order by client.LastName, client.FirstName;