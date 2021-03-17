//package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    static com.napier.sem.Sql app;

    @BeforeAll
    static void init()
    {
        app = new com.napier.sem.Sql();
        app.connect("sql:3306");
    }

    @Test
    void testGetCity(){
        //com.napier.sem.City city = app.getCity();
    }
}
