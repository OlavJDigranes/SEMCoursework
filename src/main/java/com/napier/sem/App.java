package com.napier.sem;

import java.sql.*;


public class App {
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        Sql db = new Sql();
        db.connect();
        db.disconnect();
    }

}
