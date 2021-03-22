import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.napier.sem.*;

import java.sql.Connection;
import java.util.ArrayList;

public class UnitTests {
    Sql db = new Sql();
    Connection con = db.connect("sql:3306");

    @Test
    void exampleTest()
    {
        assertEquals(5, 5);
    }

    @Test
    void testCapitalCitiesWorld() {
        // Arrange
        // Act
        ArrayList<City> returnValue = db.getCapitalCitiesWorld(con);
        // Assert
        assertTrue(returnValue.get(0).name == "Seoul");
        assertTrue(returnValue.get(0).country == "South Korea");
        assertTrue(returnValue.get(0).population == 9981619);
    }

    @Test
    void testCapitalCitiesContinent() {
        // Arrange
        // Act
        ArrayList<City> returnValue = db.getCapitalCitiesContinent(con, "Europe");
        // Assert
        assertTrue(returnValue.get(0).name == "Moscow");
        assertTrue(returnValue.get(0).country == "Russian Federation");
        assertTrue(returnValue.get(0).population == 8389200);
    }

    @Test
    void testCapitalCitiesRegion() {
        // Arrange
        // Act
        ArrayList<City> returnValue = db.getCapitalCitiesRegion(con, "Southeast Asia");
        // Assert
        assertTrue(returnValue.get(0).name == "Jakarta");
        assertTrue(returnValue.get(0).country == "Indonesia");
        assertTrue(returnValue.get(0).population == 9604900);
    }

    @Test
    void testLanguageSpeakers() {
        // Arrange
        // Act
        int returnValue = db.getLanguageSpeakers(con, "Chinese");
        // Assert
        assertTrue(returnValue == 1191843539);
        // Act
        returnValue = db.getLanguageSpeakers(con, "Spanish");
        // Assert
        assertTrue(returnValue == 355029460);
    }

    @Test
    void testPopulationUrbanRuralContinent() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationUrbanRuralRegion() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationUrbanRuralCountry() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationWorld() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationContinent() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationRegion() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationCountry() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationDistrict() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testPopulationCity() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCitiesByPopulationWorld() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCitiesByPopulationContinent() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCitiesByPopulationRegion() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCitiesByPopulationCountry() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCitiesByPopulationDistrict() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCountriesByPopulationWorld() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCountriesByPopulationRegion() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testCountriesByPopulationDistrict() {
        // Arrange
        // Act
        // Assert
    }


}
