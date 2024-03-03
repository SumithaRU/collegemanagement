package com.collegemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Complaint
{
    Connection con;
    String query;
     public void collegecomplaint(String dep,String regno,String description)
     {
         String x="College";
         String z="Not reviewed";
         con=dbConnection.createdbconnection();
         query="insert into complaint(department, regno, description, areaofissue, status) values(?,?,?,?,?)";

        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,dep);
            pstm.setString(2,regno);
            pstm.setString(3,description);
            pstm.setString(4,x);
            pstm.setString(5,z);
            int count=pstm.executeUpdate();
            if(count!=0) {
                System.out.println();
                System.out.println("<--------->Your Issue Registered Successfully<--------->");
                System.out.println();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
         System.out.println("+----------------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
         System.out.format("| %-20s | %-20s | %-100s | %-20s | %-20s |\n", "DEPARTMENT", "REG.NO","DESCRIPTION", "AREA OF ISSUE", "STATUS");
         System.out.println("+----------------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
         query="select department, regno, description, areaofissue, status from complaint where regno=?";
         try {
             PreparedStatement pstm=con.prepareStatement(query);
             pstm.setString(1,regno);
             ResultSet result=pstm.executeQuery();
             while(result.next())
             {
                 System.out.format("| %-20s | %-20s | %-100s | %-20s | %-20s |\n",
                         result.getString(1),
                         result.getString(2),
                         result.getString(3),
                         result.getString(4),
                         result.getString(5));
                 System.out.println("+----------------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
             }
             }catch (Exception e) {
             e.printStackTrace();
         }

     }
    public void hostelcomplaint(String dep,String regno,String description) {
        String x = "Hostel";
        String z = "Not reviewed";
        con = dbConnection.createdbconnection();
        query = "insert into complaint (department, regno, description, areaofissue, status) values(?,?,?,?,?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, dep);
            pstm.setString(2, regno);
            pstm.setString(3, description);
            pstm.setString(4, x);
            pstm.setString(5, z);
            int count = pstm.executeUpdate();
            if (count != 0) {
                System.out.println();
                System.out.println("<--------->Your Issue Registered Successfully<--------->");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("+----------------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-20s | %-100s | %-20s | %-20s |\n", "DEPARTMENT", "REG.NO","DESCRIPTION", "AREA OF ISSUE", "STATUS");
        System.out.println("+----------------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
        query = "select department, regno, description, areaofissue, status from complaint where regno=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, regno);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                System.out.format("| %-20s | %-20s | %-100s | %-20s | %-20s |\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                System.out.println("+----------------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    public void buscomplaint(String dep, String regno, int busno,String route, String description) {
        String x = "College Bus";
        String z = "Not reviewed";
        con = dbConnection.createdbconnection();
        query = "insert into bus(department, registerno, busno, route, description,areofissue, status) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, dep);
            pstm.setString(2, regno);
            pstm.setInt(3, busno);
            pstm.setString(4, route);
            pstm.setString(5, description);
            pstm.setString(6, x);
            pstm.setString(7, z);
            int count = pstm.executeUpdate();
            if (count != 0) {
                System.out.println();
                System.out.println("<--------->Your Issue Registered Successfully<--------->");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("+----------------------+----------------------+------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+");
        System.out.format("| %-20s | %-20s | %-10s | %-30s | %-100s | %-20s |\n", "DEPARTMENT", "REG.NO", "BUSNO","ROUTE","DESCRIPTION", "STATUS");
        System.out.println("+----------------------+----------------------+------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+");
        query = "select department, registerno, busno, route, description, status from bus where registerno=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, regno);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                System.out.format("| %-20s | %-20s | %-10d | %-30s | %-100s | %-20s |\n",
                        result.getString(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println("+----------------------+----------------------+------------+----------------------+--------------------------------------------------------------------------------------------------------+----------------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
}
}
