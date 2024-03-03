package com.collegemanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RegisterInterface dn = new RegisterImp();
        Technician technician = new Technician();
        System.out.println();
        System.out.println("<~~~~~~~~~* Welcome to Complaint Management Application *~~~~~~~~~>");
        System.out.println();
        do {
            System.out.println("""
                    Press
                    ******
                    1.Student
                    2.Technician
                    3.Admin
                    """);
            int n = 0;
            boolean validinput = false;
            while (!validinput) try {
                System.out.println();
                System.out.print("Enter the choice --> ");
                n = s.nextInt();
                validinput = true;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("<~~~~~~~~~* Invalid input. Please enter an number *~~~~~~~~~>");
                System.out.println();
                s.nextLine();
            }
            switch (n) {
                case 1:
                    do {
                        System.out.println();
                        System.out.println("""
                                Press
                                ******
                                1.Register
                                2.Login
                                3.Update Student
                                4.Delete Student
                                """);
                        int m = 0;
                        boolean validstudentinput = false;
                        while (!validstudentinput) {
                            try {
                                System.out.println();
                                System.out.print("Enter the choice --> ");
                                m = s.nextInt();
                                validstudentinput = true;
                            } catch (InputMismatchException e) {
                                System.out.println();
                                System.out.println("<~~~~~~~~~* Invalid input. Please enter an number *~~~~~~~~~>");
                                System.out.println();
                                s.nextLine();
                            }
                        }
                        s.nextLine();
                        String name;
                        String emailID;
                        String password;
                        String regno;
                        String x ;
                        switch (m) {
                            case 1:
                                System.out.println("**********************");
                                System.out.println();
                                Register stud = new Register();
                                System.out.println("Enter Name : ");
                                name = s.nextLine();
                                System.out.println("Enter Email : ");
                                emailID = s.nextLine();
                                System.out.println("Enter Password : ");
                                password = s.nextLine();
                                System.out.println("Enter PhoneNumber : ");
                                String number = s.nextLine();
                                System.out.println("Enter City : ");
                                String city = s.next();
                                String usertype = "STUDENT";
                                s.nextLine();
                                do {
                                    System.out.println("Enter RegNo : ");
                                    regno = s.nextLine();
                                    x = dn.duplicatelogin(regno);
                                    if (x.equals("true")) {
                                        System.out.println();
                                        System.out.println("<~~~~~~~~~* Register number already exists * Please enter correct regno *~~~~~~~~~>");
                                        System.out.println();
                                    }
                                } while (x.equals("true"));
                                stud.setName(name);
                                stud.setEmailId(emailID);
                                stud.setPassword(password);
                                stud.setPhonenumber(number);
                                stud.setCity(city);
                                stud.setUsertype(usertype);
                                stud.setRegno(regno);
                                dn.createLogin(stud);
                                break;
                            case 2:
                                System.out.println("**********************");
                                System.out.println();
                                String loginEmailID;
                                String correctmail;
                                String loginpassword;
                                String passwordlogin;
                                Login login = new Login();
                                do {
                                    System.out.println("Enter Email : ");
                                    loginEmailID = s.next();
                                    correctmail = login.validlogin(loginEmailID);
                                    if (correctmail.equals("false")) {
                                        System.out.println();
                                        System.out.println("<~~~~~~~~~* ***USER MISMATCH (Enter a valid emailid)*** *~~~~~~~~~>");
                                        System.out.println();
                                    }
                                } while (correctmail.equals("false"));
                                loginpassword = login.login(loginEmailID);
                                do {
                                    System.out.println("Enter your login password : ");
                                    passwordlogin = s.next();
                                    if (!passwordlogin.equals(loginpassword)) {
                                        System.out.println();
                                        System.out.println("<~~~~~~~~~* ***LOGIN INVALID (Your password is incorrect)*** *~~~~~~~~~>");
                                        System.out.println();
                                    }
                                } while (!passwordlogin.equals(loginpassword));
                                System.out.println();
                                System.out.println("-----------Login Succesfull----------");
                                System.out.println();
                                System.out.println("CHOOSE YOUR ISSUE LOCATION");
                                System.out.println("**************************");
                                do {
                                    System.out.println("""
                                            1.College
                                            2.Hostel
                                            3.College Bus
                                            """);
                                    int b = 0;
                                    boolean validuserinput = false;
                                    while (!validuserinput) try {
                                        System.out.println();
                                        System.out.print("ENTER YOUR CHOICE : ");
                                        b = s.nextInt();
                                        validuserinput = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println();
                                        System.out.println("<~~~~~~~~~* Invalid input. Please enter an number *~~~~~~~~~>");
                                        System.out.println();
                                        s.nextLine();
                                    }
                                    s.nextLine();
                                    String dep;
                                    String description;
                                    switch (b) {
                                        case 1:
                                            System.out.println("***********************");
                                            System.out.println();
                                            Complaint college = new Complaint();
                                            System.out.print("Enter the Department ==> ");
                                            dep = s.nextLine();
                                            System.out.print("Enter the RegisterNumber ==> ");
                                            regno = s.nextLine();
                                            System.out.print("Please enter the complaint description\n" +
                                                    "==> ");
                                            description = s.nextLine();
                                            college.collegecomplaint(dep, regno, description);
                                            break;
                                        case 2:
                                            System.out.println("***********************");
                                            System.out.println();
                                            Complaint hostel = new Complaint();
                                            System.out.print("Enter the Department ==> ");
                                            dep = s.nextLine();
                                            System.out.print("Enter the RegisterNumber ==> ");
                                            regno = s.nextLine();
                                            System.out.print("Please enter the complaint description\n" +
                                                    "==> ");
                                            description = s.nextLine();
                                            hostel.hostelcomplaint(dep, regno, description);
                                            break;
                                        case 3:
                                            System.out.println("***********************");
                                            System.out.println();
                                            Complaint bus = new Complaint();
                                            System.out.print("Enter the Department ==> ");
                                            dep = s.nextLine();
                                            System.out.print("Enter the RegisterNumber ==> ");
                                            regno = s.nextLine();
                                            int busno = 0;
                                            boolean validbususerinput = false;
                                            while (!validbususerinput) try {
                                                System.out.print("Enter the Bus Number==> ");
                                                busno = s.nextInt();
                                                validbususerinput = true;
                                            } catch (InputMismatchException e) {
                                                System.out.println();
                                                System.out.println("<~~~~~~~~~* Invalid input. Please enter an number *~~~~~~~~~>");
                                                System.out.println();
                                                s.nextLine();
                                            }
                                            System.out.print("Enter the Bus Route ==> ");
                                            s.nextLine();
                                            String route;
                                            route = s.nextLine();
                                            System.out.print("Please enter the complaint description\n" +
                                                    "==> ");
                                            description = s.nextLine();
                                            bus.buscomplaint(dep, regno, busno, route, description);
                                            break;
                                        default:
                                            System.out.println("<**** Enter a valid choice(1 or 2 or 3) ****>");
                                    }
                                }while(true);
                            case 3:
                                System.out.println("**********************");
                                System.out.println();
                                System.out.println("Enter your RegNo : ");
                                regno = s.nextLine();
                                s.nextLine();
                                System.out.println("Enter your Name : ");
                                name = s.nextLine();
                                System.out.println("Enter your New Password : ");
                                password = s.nextLine();
                                dn.updateLogin(name, password, regno);
                                break;

                            case 4:
                                System.out.println("**********************");
                                System.out.println();
                                System.out.println("Enter the RegNo you wanna delete : ");
                                regno = s.nextLine();
                                dn.deleteLogin(regno);
                                break;
                            default:
                                System.out.println("<**** Enter a valid choice(1 or 2 or 3 or 4) ****>");
                        }
                  }
                    while (true);
            case 2:
                System.out.println("**********************");
                System.out.println();
                String technicianid;
                String techniciancorrectmail;
                String technicianpasswordlogin;
                do {
                    System.out.println("Enter your technician id : ");
                    technicianid = s.next();
                    techniciancorrectmail = technician.correcttechnicianmailid(technicianid);
                    if (techniciancorrectmail.equals("false")) {
                        System.out.println();
                        System.out.println("<~~~~~~~~~* ***TECHNICIAN MISMATCH (Enter a valid technicianid)*** *~~~~~~~~~>");
                        System.out.println();
                    }
                } while (techniciancorrectmail.equals("false"));
                String technicianpasswordloginhere = technician.technicianlogin(technicianid);

                do {
                    System.out.println("Enter your technician password : ");
                    technicianpasswordlogin = s.next();
                    if (!technicianpasswordlogin.equals(technicianpasswordloginhere)) {
                        System.out.println();
                        System.out.println("<~~~~~~~~~* ***LOGIN INVALID (Your technician password is incorrect)*** *~~~~~~~~~>");
                        System.out.println();
                    }
                } while (!technicianpasswordlogin.equals(technicianpasswordloginhere));
                System.out.println();
                System.out.println("<~~~~~~~~~* !!!! Technician Login Successfull!!!!! *~~~~~~~~~>");
                System.out.println();
                technician.technicianwork();
                System.out.println("*** Enter 9 to log out ***");
                System.out.println();
                boolean validinputhere = false;
                while (!validinputhere)
                    try {
                        System.out.print("Enter your choice : ");
//                        int z = s.nextInt();
                        validinputhere = true;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("<~~~~~~~~~* Invalid input. Please enter an number *~~~~~~~~~>");
                        System.out.println();
                        s.nextLine();
                    }
                System.out.println();
                System.out.println();
                System.out.println("<~~~~~~~~~* !!!!Logout Successfull!!!!! *~~~~~~~~~>");
                System.out.println();
                break;
            case 3:
                System.out.println("**********************");
                System.out.println();
                Admin admin = new Admin();
                String adminid;
                String adminloginpassword;
                String admincorrectmail;
                String adminpasswordlogin;
                do {
                    System.out.println("Enter your admin id : ");
                    adminid = s.next();
                    admincorrectmail = admin.correctadminmailid(adminid);
                    if (admincorrectmail.equals("false")) {
                        System.out.println();
                        System.out.println("<~~~~~~~~~* ***ADMIN MISMATCH (Enter a valid adminid)*** *~~~~~~~~~>");
                        System.out.println();
                    }
                } while (admincorrectmail.equals("false"));
                adminloginpassword = admin.adminlogin(adminid);

                do {
                    System.out.println("Enter your admin password : ");
                    adminpasswordlogin = s.next();
                    if (!adminpasswordlogin.equals(adminloginpassword)) {
                        System.out.println();
                        System.out.println("<~~~~~~~~~* ***LOGIN INVALID (Your admin password is incorrect)*** *~~~~~~~~~>");
                        System.out.println();
                    }
                } while (!adminpasswordlogin.equals(adminloginpassword));
                System.out.println();
                System.out.println("<~~~~~~~~~* !!!! Admin Login Successfull!!!!! *~~~~~~~~~>");
                System.out.println();
                do {
                    System.out.println("""
                            Press
                            ******
                            0.View all user
                            1.View all issues
                            5.Modify issue status
                            9.Log Out""");
                    System.out.println();
                    int z = 0;
                    boolean validlogoutinputhere = false;
                    while (!validlogoutinputhere)
                        try {
                            System.out.print("Enter your choice : ");
                            z = s.nextInt();
                            validlogoutinputhere = true;
                        } catch (InputMismatchException e) {
                            System.out.println();
                            System.out.println("<~~~~~~~~~* Invalid input. Please enter an number *~~~~~~~~~>");
                            System.out.println();
                            s.nextLine();
                        }
                    System.out.println();
                    switch (z) {
                        case 0:
                            System.out.println();
                            dn.showAllLogin();
                            break;
                        case 1:
                            System.out.println();
                            technician.technicianwork();
                            break;
                        case 5:
                            int a = 0;
                            do{
                            System.out.println("""
                                    0.Bus\s
                                    1.College/Hostel
                                    9.Log out""");
                            System.out.println();

                            boolean here = false;
                            while (!here)
                                try {
                                    System.out.print("Enter your choice : ");
                                    a = s.nextInt();
                                    here = true;
                                } catch (InputMismatchException e) {
                                    System.out.println();
                                    System.out.println("<~~~~~~~~~* Invalid input. Please enter an number *~~~~~~~~~>");
                                    System.out.println();
                                    s.nextLine();
                                }
                             int newid;
                            System.out.println();
                            switch (a) {
                                case 0:
                                    System.out.println("**********************");
                                    System.out.println();
                                    System.out.print("Enter the complaint id no : ");
                                    newid=s.nextInt();
                                    admin.modifycomplaint(newid);
                                    break;
                                case 1:
                                    System.out.println("**********************");
                                    System.out.println();
                                    System.out.print("Enter the complaint id no : ");
                                    newid=s.nextInt();
                                    admin.modifyclgcomplaint(newid);
                                    break;
                                case 9:
                                    System.out.println();
                                    System.out.println("<~~~~~~~~~* !!!!Logout Successfull!!!!! *~~~~~~~~~>");
                                    System.out.println();
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Enter (0 or 1 or 9)");

                            }
                    }while(true);
                        case 9:
                            System.out.println();
                            System.out.println("<~~~~~~~~~* !!!!Logout Successfull!!!!! *~~~~~~~~~>");
                            System.out.println();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("<**** Enter a valid choice(0 or 1 or 5 or 9) ****>");
                    }
                }while(true);
            default:
                System.out.println("<**** Enter a valid choice(1 or 2 or 3) ****>");
        }
        }while(true);
    }
}



