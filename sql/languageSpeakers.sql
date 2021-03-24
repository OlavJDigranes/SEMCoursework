-- 40455050

-- This is a file as part of my exploratory SQL queries to gather the required data for the SEM coursework.

-- As a member of the team I want to produce the number of people who speak the following: Chinese, English, Hindi, Spanish and Arabic; from greatest number of speakers to smallest, including the percentage of world population so that the requirements of the coursework are met.


-- final table
SELECT
  language
  ,sum(language_speakers) AS speakers
  ,((sum(language_speakers) / (SELECT
    sum(population)
  FROM
    country))*100) AS percentage
FROM
  (
  SELECT
    country.name AS name
    ,countrylanguage.language AS language
    ,countrylanguage.percentage AS percentage
    ,country.population AS total_population
    ,FLOOR(country.population*(countrylanguage.percentage/100)) AS language_speakers
  FROM
    (countrylanguage JOIN country ON countrylanguage.countrycode=country.code)
  WHERE
    countrylanguage.percentage > 0
  ORDER BY
    (country.population*(countrylanguage.percentage/100)) DESC
) languageSpeakers
WHERE
  language LIKE "Chinese" OR language LIKE "English" OR language LIKE "Hindi" OR language LIKE "Spanish" OR language LIKE "Arabic"
GROUP BY
  language
ORDER BY
  sum(language_speakers) DESC;






-- list of number of speakers
SELECT
  language
  ,sum(language_speakers) AS speakers
FROM
  (
  SELECT
    country.name AS name
    ,countrylanguage.language AS language
    ,countrylanguage.percentage AS percentage
    ,country.population AS total_population
    ,FLOOR(country.population*(countrylanguage.percentage/100)) AS language_speakers
  FROM
    (countrylanguage JOIN country ON countrylanguage.countrycode=country.code)
  WHERE
    countrylanguage.percentage > 0
  ORDER BY
    (country.population*(countrylanguage.percentage/100)) DESC
) languageSpeakers
GROUP BY
  language
ORDER BY
  sum(language_speakers) DESC;




-- English
SELECT
  country.name AS name
  ,countrylanguage.language AS language
  ,countrylanguage.percentage AS percentage
  ,country.population AS total_population
  ,FLOOR(country.population*(countrylanguage.percentage/100)) AS language_speakers
FROM
  (countrylanguage JOIN country ON countrylanguage.countrycode=country.code)
WHERE
    language LIKE "English"
  AND
  countrylanguage.percentage > 0
ORDER BY
  (country.population*(countrylanguage.percentage/100)) DESC;
