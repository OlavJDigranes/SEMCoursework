-- 40455050

-- This is a file as part of my exploratory SQL queries to gather the required data for the SEM coursework.

-- As a member of the team I want to produce a list of all people, people living in cities and people not living in cities in each continent, region or country; so that the requirements of the coursework are met.

-- Until I get clarification by the client I will assume that means any entry in the City table.

-- of world: city pop
-- SELECT
--   (SELECT sum(population)
--   FROM country) as total_population, sum(city.population) as city_population, ((SELECT sum(population)
--   FROM country)-sum(city.population)) as non_city_population
-- FROM
--   (city join country on city.CountryCode=country.Code);


-- of continent
SELECT
  totalPop.continent AS continent
  ,total_population
  ,city_population
  ,(total_population-city_population) AS non_city_population
FROM
  (SELECT
    continent
    ,sum(population) AS total_population
  FROM
    country
  GROUP BY
    continent
  ORDER BY
    sum(population) DESC
) totalPop JOIN (
  SELECT
    continent
    ,sum(city.population) AS city_population
  FROM
    (city JOIN country ON city.CountryCode=country.Code)
  GROUP BY
    continent
  ORDER BY
   sum(city.population) DESC
) cityPop ON totalPop.continent=cityPop.continent
ORDER BY
  total_population DESC;


-- of region
SELECT
  totalPop.region AS region
  ,total_population
  ,city_population
  ,(total_population-city_population) AS non_city_population
FROM
  (SELECT
    region
    ,sum(population) AS total_population
  FROM
    country
  GROUP BY
    region
  ORDER BY
    sum(population) DESC
) totalPop JOIN (
  SELECT
    region
    ,sum(city.population) AS city_population
  FROM
    (city JOIN country ON city.CountryCode=country.Code)
  GROUP BY
    region
  ORDER BY
   sum(city.population) DESC
) cityPop ON totalPop.region=cityPop.region
ORDER BY
  total_population DESC;


-- of country (This returns some non-city populations that are negative numbers. This is not because this algorithm is wrong, but because the data itself is inconsistent. The two cities in the "Cocos (Keeling) Islands" have a pop that adds up to 670, but the country itself is listed as a total pop of only 600)
SELECT
  totalPop.name AS name
  ,total_population
  ,city_population
  ,(total_population-city_population) AS non_city_population
FROM
  (SELECT
    name
    ,sum(population) AS total_population
  FROM
    country
  GROUP BY
    name
  ORDER BY
    sum(population) DESC
) totalPop JOIN (
  SELECT
    country.name AS name
    ,sum(city.population) AS city_population
  FROM
    (city JOIN country ON city.CountryCode=country.Code)
  GROUP BY
    country.name
  ORDER BY
   sum(city.population) DESC
) cityPop ON totalPop.name=cityPop.name
ORDER BY
  total_population DESC;
















-- OLD ALGORITHMS BELOW, PLEASE IGNORE




-- of continent
SELECT
  (SELECT
    sum(population)
  FROM
    country
  WHERE  country.continent LIKE "Asia") AS total_population
  ,sum(city.population) AS city_population
  ,((SELECT
    sum(population)
  FROM
    country
  WHERE  country.continent LIKE "Asia")-sum(city.population)) AS non_city_population
FROM
  (city JOIN country ON city.CountryCode=country.Code)
WHERE
  country.continent LIKE "Asia";

-- of region
SELECT
  (SELECT
    sum(population)
  FROM
    country
  WHERE country.region LIKE "Southeast Asia") AS total_population
  ,sum(city.population) AS city_population
  ,((SELECT
    sum(population)
  FROM
    country
  WHERE country.region LIKE "Southeast Asia")-sum(city.population)) AS non_city_population
FROM
  (city JOIN country ON city.CountryCode=country.Code)
WHERE
  country.region LIKE "Southeast Asia";


-- of country
SELECT
  (SELECT
    sum(population)
  FROM
    country
  WHERE country.name LIKE "Laos") AS total_population
  ,sum(city.population) AS city_population
  ,((SELECT
    sum(population)
  FROM
    country
  WHERE country.name LIKE "Laos")-sum(city.population)) AS non_city_population
FROM
  (city JOIN country ON city.CountryCode=country.Code)
WHERE
  country.name LIKE "Laos";











SELECT
  (SELECT
    sum(population)
  FROM
    country
  WHERE  country.continent LIKE "Asia") AS total_population
  ,sum(city.population) AS city_population
  ,((SELECT
    sum(population)
  FROM
    country
  WHERE  country.continent LIKE "Asia")-sum(city.population)) AS non_city_population
FROM
  (city JOIN country ON city.CountryCode=country.Code)
WHERE
  country.continent LIKE "Asia";



-- TOTAL POP GROUP BY
SELECT
  continent
  ,sum(population) AS total_population
FROM
  country
GROUP BY
  continent
ORDER BY
  sum(population) DESC;


-- CITY POP GROUP BY
SELECT
  continent
  ,sum(city.population) AS city_population
FROM
  (city JOIN country ON city.CountryCode=country.Code)
GROUP BY
  continent
ORDER BY
  sum(city.population) DESC;

-- COMBINED POP GROUP BY
SELECT
  totalPop.continent AS continent
  ,total_population
  ,city_population
  ,(total_population-city_population) AS non_city_population
FROM
  (SELECT
    continent
    ,sum(population) AS total_population
  FROM
    country
  GROUP BY
    continent
  ORDER BY
    sum(population) DESC
) totalPop JOIN (
  SELECT
    continent
  ,sum(city.population) AS city_population
  FROM
    (city JOIN country ON city.CountryCode=country.Code)
  GROUP BY
  continent
  ORDER BY
  sum(city.population) DESC


) cityPop ON totalPop.continent=cityPop.continent
ORDER BY
total_population DESC;
