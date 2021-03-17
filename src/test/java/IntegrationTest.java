package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    static Sql app;

    @BeforeAll
    static void init()
    {
        app = new Sql();
        app.connect("sql:3306");
    }

    @Test
    void testGetCity(){
        assertEquals(5, 5);
        //com.napier.sem.City city = app.getCity();
    }
}
