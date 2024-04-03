use personaltrainer;

-- 1) Select all columns from ExerciseCategory and Exercise.
select *
from exercise, exercisecategory
where
    exercise.ExerciseCategoryId = exercisecategory.ExerciseCategoryId;

-- 2) Select ExerciseCategory.Name and Exercise.Name where the ExerciseCategory does not have a ParentCategoryId (it is null).
select ExerciseCategory.Name, Exercise.Name
from exercise
    left join exercisecategory on exercise.ExerciseCategoryId = exercisecategory.ExerciseCategoryId
where
    exercisecategory.ParentCategoryId is null;

-- 3) The query above is a little confusing. At first glance, it's hard to tell which Name belongs to ExerciseCategory and which belongs to Exercise.
select ExerciseCategory.Name as CategoryName, Exercise.Name as ExerciseName
from exercise
    left join exercisecategory on exercise.ExerciseCategoryId = exercisecategory.ExerciseCategoryId
where
    exercisecategory.ParentCategoryId is null;

-- 4) Select FirstName, LastName, and BirthDate from Client and EmailAddress from Login where Client.BirthDate is in the 1990s.
select client.FirstName, client.LastName, client.BirthDate, login.EmailAddress
from client
    left join login on client.ClientId = login.ClientId
where
    client.BirthDate between '1990-01-01' and '1999-12-31';

-- 5) Select Workout.Name, Client.FirstName, and Client.LastName for Clients with LastNames starting with 'C'?
select workout.Name, client.FirstName, client.LastName
from
    client
    inner join clientworkout on client.ClientId = clientworkout.ClientId
    inner join workout on workout.WorkoutId = clientworkout.WorkoutId
where
    client.LastName like 'C%';

-- 6) Select Names from Workouts and their Goals.
select workout.Name as Workout, goal.Name as Goal
from
    workoutgoal
    left join workout on workout.WorkoutId = workoutgoal.WorkoutId
    left join goal on goal.GoalId = workoutgoal.GoalId;

-- 7.1) Select client names and email addresses.
select client.FirstName, client.LastName, login.EmailAddress
from client
    left join login on client.ClientId = login.ClientId;

-- 7.2) Using the query above as a foundation, select Clients who do not have a Login.
select client.FirstName, client.LastName
from client
    left join login on client.ClientId = login.ClientId
where
    login.EmailAddress is null;

-- 8) Does the Client, Romeo Seaward, have a Login?
select client.FirstName, client.LastName, if(
        login.EmailAddress is null, 'NO', 'YES'
    ) as HasLogin
from client
    left join login on client.ClientId = login.ClientId
where
    client.FirstName = 'Romeo' && client.LastName = 'Seaward';

-- 9) Select ExerciseCategory.Name and its parent ExerciseCategory's Name.
select
    exercisecategory.Name as ExerciseCategory,
    parentcategory.Name as ParentCategory
from
    exercisecategory
    inner join exercisecategory as parentcategory on exercisecategory.ParentCategoryId = parentcategory.ExerciseCategoryId;

-- 10) Rewrite the query above so that every ExerciseCategory.Name is included, even if it doesn't have a parent.
select
    exercisecategory.Name as ExerciseCategory,
    parentcategory.Name as ParentCategory
from
    exercisecategory
    left join exercisecategory as parentcategory on exercisecategory.ParentCategoryId = parentcategory.ExerciseCategoryId;

-- 11) Are there Clients who are not signed up for a Workout?
select client.FirstName, client.LastName
from client
    left join clientworkout on client.ClientId = clientworkout.ClientId
where
    clientworkout.WorkoutId is null;

-- 12) Which Beginner-Level Workouts satisfy at least one of Shell Creane's Goals?
select workout.Name as Workout, goal.Name as Goal
from
    client
    left join clientgoal on client.ClientId = clientgoal.ClientId
    left join goal on clientgoal.GoalId = goal.GoalId
    left join workoutgoal on goal.GoalId = workoutgoal.GoalId
    left join workout on workoutgoal.WorkoutId = workout.WorkoutId
where
    client.FirstName = 'Shell'
    and client.LastName = 'Creane'
    and workout.LevelId = 1;

-- 13) Select Workout.Name and Exercise.Name for related Workouts and Exercises.
select workout.Name as Workout, exercise.Name as Exercise
from
    workout
    inner join workoutday on workout.WorkoutId = workoutday.WorkoutId
    inner join workoutdayexerciseinstance on workoutday.WorkoutDayId = workoutdayexerciseinstance.WorkoutDayId
    inner join exerciseinstance on workoutdayexerciseinstance.ExerciseInstanceId = exerciseinstance.ExerciseInstanceId
    inner join exercise on exercise.ExerciseId = exerciseinstance.ExerciseId;

-- 14) Select Exercise.Name, ExerciseInstanceUnitValue.Value, and Unit.Name for the 'Plank' exercise.
select exercise.Name, exerciseinstanceunitvalue.Value, unit.Name
from
    exerciseinstanceunitvalue
    left join unit on exerciseinstanceunitvalue.UnitId = unit.UnitId
    left join exerciseinstance on exerciseinstanceunitvalue.ExerciseInstanceId = exerciseinstance.ExerciseInstanceId
    left join exercise on exerciseinstance.ExerciseId = exercise.ExerciseId
where
    exercise.Name = 'Plank';