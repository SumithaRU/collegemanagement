package com.collegemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Technician {
    Connection con;
    public String correcttechnicianmailid(String technicianid)
    {
        String correct = "false";
        con=dbConnection.createdbconnection();
        String query="select technicianid from technician where technicianid=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,technicianid);
            ResultSet result= pstm.executeQuery();
            if (result.next())
            {
                correct = "true";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return correct;
    }
    public String technicianlogin(String technicianid) {
    con=dbConnection.createdbconnection();
        String query="select technicianpassword from technician where technicianid=?";
        String loginpassword="";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,technicianid);
            ResultSet result= pstm.executeQuery();
            while(result.next())
            {
                loginpassword=result.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginpassword;
    }
    public void technicianwork()
    {
        con=dbConnection.createdbconnection();
        String query="select complaintid,department,description,areaofissue,status from complaint where status='Not reviewed'" ;
        System.out.println("+----------------------+----------------------+------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-20s | %-100s | %-20s | %-20s |\n", "COMPLAINT ID","DEPARTMENT","DESCRIPTION", "AREA OF ISSUE", "STATUS");
        System.out.println("+----------------------+----------------------+------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            ResultSet result= pstm.executeQuery();
            while(result.next())
            {
                System.out.format("| %-20d | %-20s | %-100s | %-20s | %-20s |\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                System.out.println("+----------------------+----------------------+------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        String now="select complaintid,department,busno,route,description,areaofissue, status from bus where status='Not reviewed'";
        System.out.println("+----------------------+----------------------+------------+--------------------------------+------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-20s | %-10s | %-30s | %-100s | %-20S | %-20s |\n", "COMPLAINT ID","DEPARTMENT", "BUSNO","ROUTE","DESCRIPTION","AREA OF ISSUE", "STATUS");
        System.out.println("+----------------------+----------------------+------------+--------------------------------+------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
            try {
                PreparedStatement pstm=con.prepareStatement(now);
                ResultSet result= pstm.executeQuery();
                while(result.next()) {
                    System.out.format("| %-20d | %-20s | %-10d | %-30s | %-100s | %-20S | %-20s |\n",
                            result.getInt(1),
                            result.getString(2),
                            result.getInt(3),
                            result.getString(4),
                            result.getString(5),
                            result.getString(6),
                            result.getString(7));
                    System.out.println("+----------------------+----------------------+------------+--------------------------------+------------------------------------------------------------------------------------------------------+----------------------+----------------------+");
                }
            } catch (Exception e) {
                e.printStackTrace();
        }
        System.out.println();
    }
    public void updated(int id) {
        con = dbConnection.createdbconnection();
        String query = "select complaintid,regno,department,description,areaofissue,status from complaint where complaintid=?";
        System.out.println("+----------------------+--------------------------------+----------------------+----------------------------------------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-30s | %-20s | %-50s | %-20s | %-20s |\n", "COMPLAINT ID","REGISTER NO", "DEPARTMENT", "DESCRIPTION", "AREA OF ISSUE", "STATUS");
        System.out.println("+----------------------+--------------------------------+----------------------+----------------------------------------------------+----------------------+----------------------+");
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                System.out.format("| %-20d | %-30s | %-20s | %-50s | %-20s | %-20s |\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println("+----------------------+--------------------------------+----------------------+----------------------------------------------------+----------------------+----------------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    public void updatedbus(int id)
    {
        con = dbConnection.createdbconnection();
        String now="select complaintid,registerno,department,busno,route,description,areaofissue, status from bus where complaintid=?";
        System.out.println("+----------------------+--------------------------------+----------------------+------------+--------------------------------+--------------------------------------------------+----------------------+----------------------+");
        System.out.format(" | %-20s | %-30s | %-20s | %-10s | %-30s | %-50s | %-20S | %-20s |\n", "COMPLAINT ID","REGISTER NO","DEPARTMENT", "BUSNO","ROUTE","DESCRIPTION","AREA OF ISSUE", "STATUS");
        System.out.println("+----------------------+--------------------------------+----------------------+------------+--------------------------------+--------------------------------------------------+----------------------+----------------------+");
        try {
            PreparedStatement pstm=con.prepareStatement(now);
            pstm.setInt(1,id);
            ResultSet result= pstm.executeQuery();
            while(result.next()) {
                System.out.format("| %-20d | %-30s | %-20s | %-10d | %-30s | %-50s | %-20S | %-20s |\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8));
                System.out.println("+----------------------+--------------------------------+----------------------+------------+--------------------------------+--------------------------------------------------+----------------------+----------------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
