-- 40455050

-- This is a file as part of my exploratory SQL queries to gather the required data for the SEM coursework.

-- As a member of the team I want to produce the population of the world, a continent, a region, a country, a district, or a city specified by the user so that the requirements of the coursework are met.


-- of world
SELECT
  sum(population)
FROM
  country;


-- of continent
SELECT
  sum(population)
FROM
  country
WHERE
  continent like "Asia";


-- of region
SELECT
  sum(population)
FROM
  country
WHERE
  region like "Southeast Asia";


-- of country
SELECT
  population
FROM
  country
WHERE
  name like "Laos";


-- of district
SELECT
  sum(population)
FROM
  city
WHERE
  district like "Viangchan";


-- of city
SELECT
  population
FROM
  city
WHERE
  name like "Vientiane";
