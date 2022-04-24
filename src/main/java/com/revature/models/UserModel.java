package com.revature.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 */
public class UserModel extends Model{
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String passWord = "123" ;
    private int roleId=1;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String userName, String passWord, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }



    public UserModel(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public UserModel(String userName){
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public int getRole() {
        return roleId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(int roleId) {
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return "["+
                "firstName:" + firstName  +
                " ,lastName:" + lastName  +
                " ,userName:" + userName +
                " ,email:" + email +
                " ,passWord:" + passWord +
                " ,roleId:" + roleId +
                "]"+System.lineSeparator();
    }
}


