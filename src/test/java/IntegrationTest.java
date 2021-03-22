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
    void testGetCity(){

    }

    @Test
    void testGetCountry(){

    }

    @Test
    void testGetCountryLanguage(){

    }
}
