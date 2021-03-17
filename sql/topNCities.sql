-- 40455050

-- This is a file as part of my exploratory SQL queries to gather the required data for the SEM coursework.

-- As a member of the team I want to produce a list of the top 'N' populated cities in the world, continent, region, country or district where 'N' is provided by the user; so that the requirements of the coursework are met.


-- of world
SELECT
  name
  ,population
FROM
  city
ORDER BY
  population DESC
LIMIT 4;


-- of continent
SELECT
  city
.name AS name, city.population, country.name AS country
FROM
(city JOIN country ON city.CountryCode=country.Code)
WHERE
  continent LIKE "Asia"
ORDER BY
  city.population DESC
LIMIT 4;


-- of region
SELECT
  city.name AS name
  ,city.population
  ,country.name AS country
FROM
  (city JOIN country ON city.CountryCode=country.Code)
WHERE
  region LIKE "Southeast Asia"
ORDER BY
  city.population DESC
LIMIT 4;


-- of country
SELECT
  city
.name AS name, city.population, country.name AS country
FROM
(city JOIN country ON city.CountryCode=country.Code)
WHERE
  country.name LIKE "Laos"
ORDER BY
  city.population DESC
LIMIT 4;


-- of district
SELECT
  city.name AS name
  ,city.population
  ,country.name AS country
FROM
  (city JOIN country ON city.CountryCode=country.Code)
WHERE
  city.district LIKE "Viangchan"
ORDER BY
  city.population DESC
LIMIT 4;
