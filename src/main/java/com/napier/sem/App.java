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
        Connection con = db.connect();
        System.out.println("Test1");
        City c = db.getCity(con);
        db.displayCity(c);
        db.disconnect();
    }

}
