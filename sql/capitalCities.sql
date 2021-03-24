-- 40455050

-- This is a file as part of my exploratory SQL queries to gather the required data for the SEM coursework.

-- As a member of the team I want to produce a list of all the capital cities in the world, continent or region organised by largest population to smallest so that the requirements of the coursework are met.


-- of world
SELECT
  city.name as capital, country.name as country, city.population as population
FROM
  (city join country on city.ID=country.Capital)
ORDER BY
  city.population desc;


-- of continent
SELECT
  city.name as capital, country.name as country, city.population as population
FROM
  (city join country on city.ID=country.Capital)
WHERE
  country.continent like "Asia"
ORDER BY
  city.population desc;


-- of region
SELECT
  city.name as capital, country.name as country, city.population as population
FROM
  (city join country on city.ID=country.Capital)
WHERE
  country.region like "Southeast Asia"
ORDER BY
  city.population desc;
