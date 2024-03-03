package com.collegemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Admin {
    Connection con;

    public String correctadminmailid(String adminid) {
        String correct = "false";
        con = dbConnection.createdbconnection();
        String query = "select adminid from admin where adminid=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, adminid);
            ResultSet result = pstm.executeQuery();
            if (result.next()) {
                correct = "true";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return correct;
    }

    public String adminlogin(String adminid) {
        con = dbConnection.createdbconnection();
        String query = "select adminpassword from admin where adminid=?";
        String loginpassword = "";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, adminid);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                loginpassword = result.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginpassword;
    }

    Technician modify = new Technician();

    public void modifycomplaint(int id) {

        con = dbConnection.createdbconnection();
        String query = "update bus SET status='Reviewed' where complaintid=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int count = pstm.executeUpdate();
            if (count != 0) {
                modify.updatedbus(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyclgcomplaint(int id) {

        con = dbConnection.createdbconnection();
        String query = "update complaint SET status='Reviewed' where complaintid=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int count = pstm.executeUpdate();
            if (count != 0) {
                modify.updated(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
