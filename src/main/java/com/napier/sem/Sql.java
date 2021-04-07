package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class Sql {
    /**
     * Connection to MySQL database
     */
    private Connection con = null;

    /**
     * @param location This string will contain the location of the database (local or server)
     * Connect to the MySQL database.
     */
    public Connection connect(String location)
    {
        //Connection con = null;
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        int retries = 2;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start set to 30000 for travis
                //Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                return con;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }

        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
        return null;
    }

    /**
     * @param con
     * @return Returns a city by querying the database with an already-given query.
     */
    public City getCity(Connection con)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT " +
                    "  name " +
                    "  ,population " +
                    "FROM " +
                    "  city " +
                    "ORDER BY " +
                    "  population DESC " +
                    "LIMIT 1;";
            ResultSet rset = stmt.executeQuery(strSelect);


            while(rset.next())
            {
                City city = new City();
                city.name = rset.getString("Name");
                city.population = rset.getInt("Population");

                System.out.println(city.name + " " + city.population);
                return city;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city");
            return null;
        }
        return null;
    }

    /**
     * @param con
     * @return Returns a country by querying the database with an already-given query.
     */
    public Country getCountry(Connection con)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT " +
                    "  name " +
                    "  ,population " +
                    "FROM " +
                    "  country " +
                    "ORDER BY " +
                    "  population DESC " +
                    "LIMIT 1;";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("Name");
                country.Population = rset.getInt("Population");

                System.out.println(country.Name + " " + country.Population);
                return country;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country");
            return null;
        }
        return null;
    }

    /**
     * @param con
     * @return Returns a city by querying the database with an already-given query.
     */
    public CountryLanguage getCountryLanguage(Connection con)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT " +
                    "  language " +
                    "FROM " +
                    "  countrylanguage " +
                    "LIMIT 1;";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                CountryLanguage countryLanguage = new CountryLanguage();
                countryLanguage.Language = rset.getString("Language");
                System.out.println(countryLanguage.Language);
                return countryLanguage;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country");
            return null;
        }
        return null;
    }

    /**
     * Disconnects the sql database
     */
    public void disconnect()
    {
        if(con != null)
        {
            try
            {
                con.close();
                System.out.println("Successfully disconnected.");
            }
            catch(Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }

    }


    // For all methods below:
    //      The method should check for known bad inputs and fix them or return immediately.
    //      If they return bad input nonetheless they should return either a null or -1.

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param N The number of top cities to return.
     * @return This method should return an ArrayList of all cities in the world.
     */
    public ArrayList<City> getCapitalCitiesWorld(Connection con, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT" +
                "city.name as capital, country.name as country, city.population as population, city.district as district, city.id as id" +
                "FROM" +
                "(city join country on city.ID=country.Capital)" +
                "ORDER BY" +
                "city.population desc" +
                "LIMIT " + N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cityArrayList = new ArrayList<City>();

            while (rset.next())
            {
                City newCity = new City();
                newCity.name = rset.getString("capital");
                newCity.population = rset.getInt("population");
                newCity.district = rset.getString("district");
                newCity.country = rset.getString("country");
                newCity.ID = rset.getInt("id");
                cityArrayList.add(newCity);
            }
            return cityArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of cities");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param continent This method should take a continent name as a String argument.
     * @return This method should return an ArrayList of all cities in the continent.
     */
    public ArrayList<City> getCapitalCitiesContinent(Connection con, String continent, int N) {
        return null;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param region This method should take a region name as a String argument.
     * @return This method should return an ArrayList of all cities in the region.
     */
    public ArrayList<City> getCapitalCitiesRegion(Connection con, String region, int N) {
        return null;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param language This method should take a language as a String argument.
     * @return This method should return the int population.
     */
    public int getLanguageSpeakers(Connection con, String language) {
        return 0;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param continent This method should take a continent name as a String argument.
     * @return This method should return an ArrayList containing 2 values corresponding to the urban population and the rural population in that order.
     */
    public ArrayList<Long> getPopulationUrbanRuralContinent(Connection con, String continent) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT" +
                "totalPop.continent AS continent" +
                ",total_population" +
                ",city_population" +
                ",(total_population-city_population) AS non_city_population" +
                "FROM" +
                "(SELECT" +
                "continent" +
                ",sum(population) AS total_population" +
                "FROM" +
                "country" +
                "GROUP BY" +
                "continent" +
                "ORDER BY" +
                "sum(population) DESC" +
                ") totalPop JOIN (" +
                "SELECT" +
                "continent" +
                ",sum(city.population) AS city_population" +
                "FROM" +
                "(city JOIN country ON city.CountryCode=country.Code)" +
                "GROUP BY" +
                "continent" +
                "ORDER BY" +
                "sum(city.population) DESC" +
                ") cityPop ON totalPop.continent=cityPop.continent" +
                "WHERE" +
                "totalPop.continent LIKE \"" + continent + "\"" +
                "ORDER BY" +
                "total_population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Long> popUrbanRural = new ArrayList<Long>();

            while (rset.next())
            {
                popUrbanRural.add(rset.getLong("city_population"));
                popUrbanRural.add(rset.getLong("non_city_population"));
            }
            return popUrbanRural;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the urban and rural populations of the continent named " + continent);
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param region This method should take a region name as a String argument.
     * @return This method should return an ArrayList containing 2 values corresponding to the urban population and the rural population in that order.
     */
    public ArrayList<Long> getPopulationUrbanRuralRegion(Connection con, String region) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT" +
                "totalPop.region AS region" +
                ",total_population" +
                ",city_population" +
                ",(total_population-city_population) AS non_city_population" +
                "FROM" +
                "(SELECT" +
                "region" +
                ",sum(population) AS total_population" +
                "FROM" +
                "country" +
                "GROUP BY" +
                "region" +
                "ORDER BY" +
                "sum(population) DESC" +
                ") totalPop JOIN (" +
                "SELECT" +
                "region" +
                ",sum(city.population) AS city_population" +
                "FROM" +
                "(city JOIN country ON city.CountryCode=country.Code)" +
                "GROUP BY" +
                "region" +
                "ORDER BY" +
                "sum(city.population) DESC" +
                ") cityPop ON totalPop.region=cityPop.region" +
                "WHERE" +
                "totalPop.region LIKE \"" + region + "\"" +
                "ORDER BY" +
                "total_population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Long> popUrbanRural = new ArrayList<Long>();

            while (rset.next())
            {
                popUrbanRural.add(rset.getLong("city_population"));
                popUrbanRural.add(rset.getLong("non_city_population"));
            }
            return popUrbanRural;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the urban and rural populations of the region named " + region);
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param country This method should take a country name as a String argument.
     * @return This method should return an ArrayList containing 2 values corresponding to the urban population and the rural population in that order.
     */
    public ArrayList<Long> getPopulationUrbanRuralCountry(Connection con, String country) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT" +
                "totalPop.name AS name" +
                ",total_population" +
                ",city_population" +
                ",(total_population-city_population) AS non_city_population" +
                "FROM" +
                "(SELECT" +
                "name" +
                ",sum(population) AS total_population" +
                "FROM" +
                "country" +
                "GROUP BY" +
                "name" +
                "ORDER BY" +
                "sum(population) DESC" +
                ") totalPop JOIN (" +
                "SELECT" +
                "country.name AS name" +
                ",sum(city.population) AS city_population" +
                "FROM" +
                "(city JOIN country ON city.CountryCode=country.Code)" +
                "GROUP BY" +
                "country.name" +
                "ORDER BY" +
                "sum(city.population) DESC" +
                ") cityPop ON totalPop.name=cityPop.name" +
                "WHERE" +
                "totalPop.name LIKE \"" + country + "\"" +
                "ORDER BY" +
                "total_population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Long> popUrbanRural = new ArrayList<Long>();

            while (rset.next())
            {
                popUrbanRural.add(rset.getLong("city_population"));
                popUrbanRural.add(rset.getLong("non_city_population"));
            }
            return popUrbanRural;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the urban and rural populations of the country named " + country);
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @return This method should return the long population of the world.
     */
    public long getPopulationWorld(Connection con) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT" +
                "sum(population)" +
                "FROM" +
                "country;";

            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                return rset.getLong("sum(population)");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the world.");
            return 0;
        }
        return 0;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param continent This method should take a continent name as a String argument.
     * @return This method should return the long population of a continent.
     */
    public long getPopulationContinent(Connection con, String continent) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT" +
                "sum(population)" +
                "FROM" +
                "country" +
                "WHERE" +
                "continent like \"" + continent + "\";";

            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                return rset.getLong("sum(population)");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the continent named " + continent + ".");
            return 0;
        }
        return 0;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param region This method should take a region name as a String argument.
     * @return This method should return the int population of a region.
     */
    public int getPopulationRegion(Connection con, String region) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT" +
                            "sum(population)" +
                            "FROM" +
                            "country" +
                            "WHERE" +
                            "region like \"" + region + "\";";

            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                return rset.getInt("sum(population)");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the region named " + region + ".");
            return 0;
        }
        return 0;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param country This method should take a country name as a String argument.
     * @return This method should return the int population of a country.
     */
    public int getPopulationCountry(Connection con, String country) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT" +
                            "population" +
                            "FROM" +
                            "country" +
                            "WHERE" +
                            "name like \"" + country + "\";";

            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                return rset.getInt("population");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the country named " + country + ".");
            return 0;
        }
        return 0;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param district This method should take a district name as a String argument.
     * @return This method should return the int population of a district.
     */
    public int getPopulationDistrict(Connection con, String district) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT" +
                            "sum(population)" +
                            "FROM" +
                            "city" +
                            "WHERE" +
                            "district like \"" + district + "\";";

            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                return rset.getInt("sum(population)");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the district named " + district + ".");
            return 0;
        }
        return 0;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param city This method should take a city name as a String argument.
     * @return This method should return the int population of a city.
     */
    public int getPopulationCity(Connection con, String city) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT" +
                            "population" +
                            "FROM" +
                            "city" +
                            "WHERE" +
                            "name like \"" + city + "\";";

            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                return rset.getInt("population");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the city named " + city + ".");
            return 0;
        }
        return 0;
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param N This method should take the number of top cities to display as an int argument.
     *          If the user enters N as zero then it should display all matching cities.
     * @return This method should return an ArrayList of all cities in the world in descending order of population.
     */
    public ArrayList<City> getCitiesByPopulationWorld(Connection con, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT" +
                "city.name AS name" +
                ",city.population" +
                ",country.name AS country" +
                ",city.ID as ID" +
                ",city.district as district" +
                "FROM" +
                "(city JOIN country ON city.CountryCode=country.Code)" +
                "ORDER BY" +
                "city.population DESC" +
                "LIMIT " + N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cityArrayList = new ArrayList<City>();

            while (rset.next())
            {
                City newCity = new City();
                newCity.name = rset.getString("name");
                newCity.population = rset.getInt("population");
                newCity.district = rset.getString("district");
                newCity.country = rset.getString("country");
                newCity.ID = rset.getInt("ID");
                cityArrayList.add(newCity);
            }
            return cityArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of cities by population in the world.");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param continent This method should take a continent name as a String argument.
     * @param N This method should take the number of top cities to display as an int argument.
     *          If the user enters N as zero then it should display all matching cities.
     * @return This method should return an ArrayList of all cities in a continent in descending order of population.
     */
    public ArrayList<City> getCitiesByPopulationContinent(Connection con, String continent, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT " +
                "city.name AS name " +
                ",city.population " +
                ",country.name AS country " +
                ",city.ID as ID " +
                ",city.district as district " +
                "FROM " +
                "(city JOIN country ON city.CountryCode=country.Code) " +
                "WHERE " +
                "continent LIKE \"" + continent + "\" " +
                "ORDER BY" +
                "city.population DESC" +
                "LIMIT " + N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cityArrayList = new ArrayList<City>();

            while (rset.next())
            {
                City newCity = new City();
                newCity.name = rset.getString("name");
                newCity.population = rset.getInt("population");
                newCity.district = rset.getString("district");
                newCity.country = rset.getString("country");
                newCity.ID = rset.getInt("ID");
                cityArrayList.add(newCity);
            }
            return cityArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of cities by population in the continent named " + continent + ".");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param region This method should take a region name as a String argument.
     * @param N This method should take the number of top cities to display as an int argument.
     *          If the user enters N as zero then it should display all matching cities.
     * @return This method should return an ArrayList of all cities in a region in descending order of population.
     */
    public ArrayList<City> getCitiesByPopulationRegion(Connection con, String region, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT " +
                "city.name AS name " +
                ",city.population " +
                ",country.name AS country " +
                ",city.ID as ID " +
                ",city.district as district " +
                "FROM " +
                "(city JOIN country ON city.CountryCode=country.Code) " +
                "WHERE " +
                "region LIKE \"" + region + "\" " +
                "ORDER BY" +
                "city.population DESC" +
                "LIMIT " + N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cityArrayList = new ArrayList<City>();

            while (rset.next())
            {
                City newCity = new City();
                newCity.name = rset.getString("name");
                newCity.population = rset.getInt("population");
                newCity.district = rset.getString("district");
                newCity.country = rset.getString("country");
                newCity.ID = rset.getInt("ID");
                cityArrayList.add(newCity);
            }
            return cityArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of cities by population in the region named " + region + ".");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param country This method should take a country name as a String argument.
     * @param N This method should take the number of top cities to display as an int argument.
     *          If the user enters N as zero then it should display all matching cities.
     * @return This method should return an ArrayList of all cities in a country in descending order of population.
     */
    public ArrayList<City> getCitiesByPopulationCountry(Connection con, String country, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT " +
                "city.name AS name " +
                ",city.population " +
                ",country.name AS country " +
                ",city.ID as ID " +
                ",city.district as district " +
                "FROM " +
                "(city JOIN country ON city.CountryCode=country.Code) " +
                "WHERE " +
                "country.name LIKE \"" + country + "\" " +
                "ORDER BY" +
                "city.population DESC" +
                "LIMIT " + N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cityArrayList = new ArrayList<City>();

            while (rset.next())
            {
                City newCity = new City();
                newCity.name = rset.getString("name");
                newCity.population = rset.getInt("population");
                newCity.district = rset.getString("district");
                newCity.country = rset.getString("country");
                newCity.ID = rset.getInt("ID");
                cityArrayList.add(newCity);
            }
            return cityArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of cities by population in the country named " + country + ".");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param district This method should take a district name as a String argument.
     * @param N This method should take the number of top cities to display as an int argument.
     *          If the user enters N as zero then it should display all matching cities.
     * @return This method should return an ArrayList of all cities in a district in descending order of population.
     */
    public ArrayList<City> getCitiesByPopulationDistrict(Connection con, String district, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT " +
                "city.name AS name " +
                ",city.population " +
                ",country.name AS country " +
                ",city.ID as ID " +
                ",city.district as district " +
                "FROM " +
                "(city JOIN country ON city.CountryCode=country.Code) " +
                "WHERE " +
                "city.district LIKE \"" + district + "\" " +
                "ORDER BY" +
                "city.population DESC" +
                "LIMIT " + N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cityArrayList = new ArrayList<City>();

            while (rset.next())
            {
                City newCity = new City();
                newCity.name = rset.getString("name");
                newCity.population = rset.getInt("population");
                newCity.district = rset.getString("district");
                newCity.country = rset.getString("country");
                newCity.ID = rset.getInt("ID");
                cityArrayList.add(newCity);
            }
            return cityArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of cities by population in the district named " + district + ".");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @return This method should return an ArrayList of all countries in the world in descending order of population.
     */
    public ArrayList<Country> getCountriesByPopulationWorld(Connection con, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                "SELECT * " +
                "FROM " +
                "country " +
                "ORDER BY " +
                "population DESC " +
                "LIMIT "+ N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> countryArrayList = new ArrayList<Country>();

            while (rset.next())
            {
                Country newCountry = new Country();
                newCountry.Name = rset.getString("Name");
                newCountry.Population = rset.getInt("Population");
                newCountry.Code = rset.getString("Code");
                newCountry.Capital = rset.getInt("Capital");
                newCountry.Code2 = rset.getString("Code2");
                newCountry.Continent = rset.getString("Continent");
                newCountry.GNP = rset.getFloat("GNP");
                newCountry.GNPOld = rset.getFloat("GNPOld");
                newCountry.GovernmentForm = rset.getString("GovernmentForm");
                newCountry.HeadOfState = rset.getString("HeadOfState");
                newCountry.IndepYear = rset.getInt("IndepYear");
                newCountry.LifeExpectancy = rset.getInt("LifeExpectancy");
                newCountry.LocalName = rset.getString("LocalName");
                newCountry.Region = rset.getString("Region");
                newCountry.SurfaceArea = rset.getFloat("SurfaceArea");
                countryArrayList.add(newCountry);
            }
            return countryArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of countries by population in the world.");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param continent This method should take a continent name as a String argument.
     * @return This method should return an ArrayList of all countries in a continent in descending order of population.
     */
    public ArrayList<Country> getCountriesByPopulationContinent(Connection con, String continent, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT * " +
                            "FROM " +
                            "country " +
                            "WHERE continent LIKE \"" + continent + "\" " +
                            "ORDER BY " +
                            "population DESC " +
                            "LIMIT "+ N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> countryArrayList = new ArrayList<Country>();

            while (rset.next())
            {
                Country newCountry = new Country();
                newCountry.Name = rset.getString("Name");
                newCountry.Population = rset.getInt("Population");
                newCountry.Code = rset.getString("Code");
                newCountry.Capital = rset.getInt("Capital");
                newCountry.Code2 = rset.getString("Code2");
                newCountry.Continent = rset.getString("Continent");
                newCountry.GNP = rset.getFloat("GNP");
                newCountry.GNPOld = rset.getFloat("GNPOld");
                newCountry.GovernmentForm = rset.getString("GovernmentForm");
                newCountry.HeadOfState = rset.getString("HeadOfState");
                newCountry.IndepYear = rset.getInt("IndepYear");
                newCountry.LifeExpectancy = rset.getInt("LifeExpectancy");
                newCountry.LocalName = rset.getString("LocalName");
                newCountry.Region = rset.getString("Region");
                newCountry.SurfaceArea = rset.getFloat("SurfaceArea");
                countryArrayList.add(newCountry);
            }
            return countryArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of countries by population in the continent named " + continent + ".");
            return null;
        }
    }

    /**
     * This method is a stub for unit testing. Put code in here to fulfil the requirements of the test.
     * @param con
     * @param region This method should take a region name as a String argument.
     * @return This method should return an ArrayList of all countries in a region in descending order of population.
     */
    public ArrayList<Country> getCountriesByPopulationRegion(Connection con, String region, int N) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT * " +
                            "FROM " +
                            "country " +
                            "WHERE region LIKE \"" + region + "\" " +
                            "ORDER BY " +
                            "population DESC " +
                            "LIMIT "+ N + ";";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> countryArrayList = new ArrayList<Country>();

            while (rset.next())
            {
                Country newCountry = new Country();
                newCountry.Name = rset.getString("Name");
                newCountry.Population = rset.getInt("Population");
                newCountry.Code = rset.getString("Code");
                newCountry.Capital = rset.getInt("Capital");
                newCountry.Code2 = rset.getString("Code2");
                newCountry.Continent = rset.getString("Continent");
                newCountry.GNP = rset.getFloat("GNP");
                newCountry.GNPOld = rset.getFloat("GNPOld");
                newCountry.GovernmentForm = rset.getString("GovernmentForm");
                newCountry.HeadOfState = rset.getString("HeadOfState");
                newCountry.IndepYear = rset.getInt("IndepYear");
                newCountry.LifeExpectancy = rset.getInt("LifeExpectancy");
                newCountry.LocalName = rset.getString("LocalName");
                newCountry.Region = rset.getString("Region");
                newCountry.SurfaceArea = rset.getFloat("SurfaceArea");
                countryArrayList.add(newCountry);
            }
            return countryArrayList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of countries by population in the region named " + region + ".");
            return null;
        }
    }
}
