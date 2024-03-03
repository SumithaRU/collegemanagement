package com.collegemanagement;


import java.sql.*;

public class Login
{
   Connection con;
   public String validlogin(String loginEmailID){
       String correctmail="false";
       con=dbConnection.createdbconnection();
       String query="select email_id from logintable where email_id=?";
       try {
           PreparedStatement pstm = con.prepareStatement(query);
           pstm.setString(1,loginEmailID);
           ResultSet result= pstm.executeQuery();
           while(result.next())
           {
               correctmail="true";
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }

       return correctmail;
   }
   public String login(String loginEmailID)
   {
      con=dbConnection.createdbconnection();
      String loginpassword="";
      String query="select password from logintable where email_id=?";
       try {
           PreparedStatement pstm= con.prepareStatement(query);
           pstm.setString(1,loginEmailID);
          ResultSet result=pstm.executeQuery();
          while(result.next())
          {
             loginpassword=result.getString(1);

          }
       } catch (Exception e)
       {
          e.printStackTrace();
       }
       return loginpassword;

   }

}
