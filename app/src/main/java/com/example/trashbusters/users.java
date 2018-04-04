package com.example.trashbusters;

/**
 * Created by Daniel Oh
 * This is a user class for our project
 */

public class users {

    private int usersID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String dob;
    private int userType;
    private String licenseNumber;
    private String plateNumber;

    public users() {

    }

    public users(String userName_, String password_,
            String firstName_, String lastNname_, String email_, String phoneNumber_, String address_,
                 String city_, String state_, String zip_, String dob_, int userType_, String licenseNumber_, String plateNumber_) {
        this.userName = userName_;
        this.password = password_;
        this.firstName = firstName_;
        this.lastName = lastNname_;
        this.email = email_;
        this.phoneNumber = phoneNumber_;
        this.address = address_;
        this.city = city_;
        this.state = state_;
        this.zip = zip_;
        this.dob = dob_;
        this.userType = userType_;
        this.licenseNumber = licenseNumber_;
        this.plateNumber = plateNumber_;
    }

    public void setUsersID(int n) {
        this.usersID = n;
    }

    public int getUsersID() {
        return usersID;
    }

    public void setUserName(String s) {
        this.userName = s;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String s) {
        this.password = s;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String s) {
        this.firstName = s;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String s) {
        this.lastName = s;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String s) {
        this.email = s;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String s) {
        this.phoneNumber = s;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String s) {
        this.address = s;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String s) {
        this.city = s;
    }

    public String getCity() {
        return city;
    }

    public void setState(String s) {
        this.state = s;
    }

    public String getState() {
        return state;
    }

    public void setZip(String s) {
        this.zip = s;
    }

    public String getZip() {
        return zip;
    }

    public void setDob(String s) {
        this.dob = s;
    }

    public String getDob() {
        return dob;
    }

    public void setUserType(int s) {
        this.userType = s;
    }

    public int getUserType() {
        return userType;
    }

    public void setLicenseNumber(String s) {
        this.licenseNumber = s;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }

    public void setPlateNumber(String s) {
        this.plateNumber = s;
    }

    public String getPlateNumber(){
        return plateNumber;
    }
}
