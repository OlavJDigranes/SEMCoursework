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
        assertEquals(country.Code, "ABW");
        assertEquals(country.Name, "Aruba");
        assertEquals(country.Continent, "North America");
        assertEquals(country.Region, "Caribbean");
        assertEquals(country.SurfaceArea, 193.00);
        assertEquals(country.IndepYear, "");
        assertEquals(country.Population, 103000);
        assertEquals(country.LifeExpectancy, 78.4);
        assertEquals(country.GNP, 828.00);
        assertEquals(country.GNPOld, 793.00);
        assertEquals(country.LocalName, "Aruba");
        assertEquals(country.GovernmentForm, "Nonmetropolitan Territory of The Netherlands");
        assertEquals(country.HeadOfState, "Beatrix");
        assertEquals(country.Capital, 129);
        assertEquals(country.Code2, "AW");
    }

    @Test
    void testGetCountryLanguage()
    {
        CountryLanguage countryLanguage = app.getCountryLanguage(con);
        assertEquals(countryLanguage.CountryCode, "ABW");
        assertEquals(countryLanguage.Language, "Dutch");
        assertEquals(countryLanguage.IsOfficial, true);
        assertEquals(countryLanguage.Percentage, 5.3);
    }
}
