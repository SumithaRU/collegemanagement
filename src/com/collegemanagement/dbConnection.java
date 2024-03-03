package com.collegemanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    static Connection con;
        public static Connection createdbconnection()
        {
            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/college_management";
                String username = "root";
                String password = "Qwerty123#";
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return con;

        }
    }


