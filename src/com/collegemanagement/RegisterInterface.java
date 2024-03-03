package com.collegemanagement;

public interface RegisterInterface
{
    void createLogin(Register stud);
    String duplicatelogin(String regno);

    void showAllLogin();


    void updateLogin(String name,String password, String regno);
        void deleteLogin(String regno);
}
