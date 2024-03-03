package com.collegemanagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class RegisterImp implements RegisterInterface
{
 Connection con;

    @Override
    public void createLogin(Register stud)
    {
       Connection con = dbConnection.createdbconnection();
     String query="insert into logintable values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setString(1,stud.getName());
            pstm.setString(2,stud.getEmailId());
            pstm.setString(3,stud.getPassword());
            pstm.setString(4,stud.getPhonenumber());
            pstm.setString(5,stud.getCity());
            pstm.setString(6,stud.getUsertype());
            pstm.setString(7,stud.getRegno());
         int count=pstm.executeUpdate();
         if(count!=0) {
             System.out.println();
             System.out.println("<--------->Student Registered Successfully<--------->");
             System.out.println();
         }
          } catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public String duplicatelogin(String regno) {
        String local="false";
        con=dbConnection.createdbconnection();
        String query="select regno from logintable where regno=?";
        try {
            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setString(1,regno);
            ResultSet result=pstm.executeQuery();
            while(result.next())
            {
                local="true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return local;
    }

    @Override
    public void showAllLogin()
    {
       Connection con=dbConnection.createdbconnection();
       String query="select username,email_id,regno,phonenumber  from logintable";
        System.out.println("***************************");
        System.out.println();
        System.out.println(" ~~~~~~~~~~~~~~~~~~~");
        System.out.println("/ Students Detail /");
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("+----------------------+-------------------------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-35s | %-20s | %-20s |\n", "NAME", "EMAILID", "REGNO","PHONE NUMBER");
        System.out.println("+----------------------+-------------------------------------+----------------------+----------------------+");
       try
       {
           Statement stmt=con.createStatement();
       ResultSet result =stmt.executeQuery(query);
       while(result.next())
       {
           System.out.format("| %-20s | %-35s | %-20s | %-20s |\n",
                   result.getString(1),
                   result.getString(2),
                   result.getString(3),
                   result.getString(4));
           System.out.println("+----------------------+-------------------------------------+----------------------+----------------------+");
       }
       }catch (Exception ex)
       {
           ex.printStackTrace();
       }
        System.out.println();
    }
    @Override

    public void updateLogin(String name, String password ,String regno) {
        Connection con = dbConnection.createdbconnection();

        try {
            String query = "UPDATE logintable SET username=?, password=? WHERE regno=?";

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setString(2, password);
            pstm.setString(3, regno);
            int count = pstm.executeUpdate();
            if (count != 0) {
                System.out.println();
                System.out.println("<--------->Login Information Updated Successfully<--------->");
                System.out.println();
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteLogin(String regno)
    {
        con=dbConnection.createdbconnection();
        String query="delete from logintable where regno=?";
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,regno);
            int count=pstm.executeUpdate();
            if(count!=0)
            {
                System.out.println();
                System.out.println("<--------->User Deletion Successful<--------->");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}