import com.napier.sem.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    static Sql app;
    static Connection con;

    @BeforeAll
    static void init()
    {
        app = new Sql();
        con = app.connect("sql:3306");
    }

    @Test
    void testGetCity()
    {
        City city = app.getCity(con);
        assertEquals(city.ID, 1);
        assertEquals(city.name, "Kabul");
        assertEquals(city.country, "AFG");
        assertEquals(city.district, "Kabol");
        assertEquals(city.population, 1780000);
    }

    @Test
    void testGetCountry()
    {
        Country country = app.getCountry(con);
        assertEquals(country.Code, "AUS");
        assertEquals(country.Name, "Australia");
        assertEquals(country.Continent, "Oceania");
        assertEquals(country.Region, "Australia and New Zealand");
        assertEquals(country.SurfaceArea, 7741220.00);
        assertEquals(country.IndepYear, 1901);
        assertEquals(country.Population, 18886000);
        assertEquals(country.LifeExpectancy, 79.9);
        assertEquals(country.GNP, 351182.00);
        assertEquals(country.GNPOld, 392911.00);
        assertEquals(country.LocalName, "Australia");
        assertEquals(country.GovernmentForm, "Constitutional Monarchy, Federation");
        assertEquals(country.HeadOfState, "Elisabeth II");
        assertEquals(country.Capital, 135);
        assertEquals(country.Code2, "AU");
    }

    @Test
    void testGetCountryLanguage()
    {

    }
}
