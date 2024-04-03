use world;

-- 1) Use SELECT queries to view the first ten rows of data and all columns in each of the three tables. Note the columns included in the table and what the data in each column looks like.
select * from city limit 10;

select * from country limit 10;

select * from countrylanguage limit 10;

-- 2) Generate a list of all cities with a population less than 10,000. Include all fields in the city table in the results. Sort the results with the largest population at the top of the list and the lowest population at the end of the list. [42 rows]
select *
from city
where
    Population < 10000
order by Population desc;

-- 3) Generate a list of all cities grouped by region and country. Include only the name of the region, the name of the country, and the name of the city. Sort the results in alphabetical order by region, country, and city. [4079 rows]
select country.Region, country.Name as Country, city.Name as City
from country
    inner join city on country.Code = city.CountryCode
order by country.Region, country.Name, city.Name;

-- 4) Generate a list of all countries where any form of French is spoken. Do not duplicate country names, even if the country speaks more than one form of French. Include the name of the country, the name of one kind of French spoken in that country, and the percentage of people in the country who speak any kind of French. Sort the data by percentage, with the largest value at the top of the list. Use a single WHERE statement without OR. Optional: use GROUP_CONCAT to list all forms of french spoken in each country inside a single field. (This only works with MySQL, though some other databases have similar features.)
select
    country.Name as Country,
    group_concat(countrylanguage.Language) as FrenchLanuages,
    sum(countrylanguage.Percentage) as Percentage
from country
    left join countrylanguage on country.Code = countrylanguage.CountryCode
where
    countrylanguage.Language like '%French%'
group by
    country.Name
order by sum(countrylanguage.Percentage) desc;

-- 5) Generate a list of countries for which no year of independence is provided. Include only the country name, continent, and population for each country in the list. Sort in alphabetical order by the country names. [47 rows]
select Name, Continent, Population
from country
where
    IndepYear is null
order by Name;

-- 6) Generate a list of countries and the languages that are spoken in each country. Include only the country name, continent, language and percentage spoken for each country. Include all countries, even those for which no language is specified. Sort by country name in alphabetical order and then by percentage, with the highest percentage first. [990 rows]

select country.name as Country, country.Continent, countrylanguage.Language, countrylanguage.Percentage
from country
    left join countrylanguage on country.Code = countrylanguage.CountryCode
order by country.name asc, countrylanguage.Percentage desc;

-- 7) Generate a list of countries for which no language is specified. Include only the country name and continent. Sort alphabetically by continent and county name. [6 rows]

select country.Name as Country, country.Continent
from country
where
    country.Code not in(
        select CountryCode
        from countrylanguage
    )
order by country.Continent, country.Name;
-- 8) Calculate the total city population for each country. Include the country name and total population in the results. Sort the results by total population, starting with the smallest value. [232 rows]
select
    country.Name as Country,
    sum(city.Population) as TotalCityPopulation
from country
    inner join city on country.Code = city.CountryCode
group by
    country.Name
order by sum(city.Population);

-- 8.1) Calculate percentage of poulation living in cities in Europe.
select
    country.Name as Country,
    round(
        sum(city.Population) / country.Population * 100, 2
    ) as TotalCityPopulation
from country
    inner join city on country.Code = city.CountryCode
where
    `Continent` = 'Europe'
group by
    country.Name,
    country.Population
order by sum(city.Population) / country.Population;

-- 9) Calculate the average city population for each continent. Include all continent names and average population in the results. Sort the results by average population, starting with the largest value. [7 rows]

select
    Continent,
    round(avg(city.Population)) as AverageCityPopulation
from country
    inner join city on country.Code = city.CountryCode
group by
    Continent
order by avg(city.Population) desc;

-- 10) Generate a list of the ten countries with the highest GNP. Include the country name and GNP columns.

select Name as Country, round(GNP) as GNP
from country
order by GNP desc
limit 10;

-- 11) Generate a list of the capital cities with the population and the official language(s) for that country. Include the name of the city, the country where the city is located, the city's population, and the country's official languages. Use meaningful names to distinguish the column headings. Sort by city name alphabetically. [983 rows]

select
    city.Name as CapitalCity,
    country.Name as Country,
    city.Population,
    group_concat(countrylanguage.Language) as `OfficialLanguage(s)`
from
    country
    inner join city on country.Capital = city.ID
    left join countrylanguage on country.Code = countrylanguage.CountryCode
group by
    city.Name,
    country.Name,
    city.Population
order by city.Name;

-- 12) Generate a list of countries and their capital cities. Include the name of the country and the name of the city in the results, using a meaningful name for each column. Include countries with no capital city. Sort alphabetically by country name. [239 records]

select country.Name as Country, if(
        city.Name is null, "No Capital", city.Name
    ) as CapitalCity
from country
    left join city on country.Capital = city.ID
order by country.Name;