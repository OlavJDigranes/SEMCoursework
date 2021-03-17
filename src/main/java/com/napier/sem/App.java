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
        db.getCity(con);
        //db.displayCity(c);
        db.disconnect();
    }

}
