package com.collegemanagement;

public class Register
{
    private String name;
    private  String emailId;
    private String password;
    private String phonenumber;
    private String city;
    private String usertype;
    private String regno;
 public Register()
 {

 }



    public Register(String name, String emailId, String password, String phonenumber, String city, String usertype, String regno)
    {
        this.name=name;
        this.emailId=emailId;
        this.password=password;
        this.phonenumber=phonenumber;
        this.city=city;
        this.usertype=usertype;
        this.regno=regno;
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", city='" + city + '\'' +
                ", usertype='" + usertype + '\'' +
                ", regno='" + regno + '\'' +
                '}';
    }
}