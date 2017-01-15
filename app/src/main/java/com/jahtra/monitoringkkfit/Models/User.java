package com.jahtra.monitoringkkfit.Models;

/**
 * Created by bungkhus on 1/15/17.
 */

public class User {

    private String kodeDosen;
    private String name;
    private String email;
    private String access;
    private String phoneNumber;

    public User() {
    }

    public User(String kodeDosen, String name, String email, String access, String phoneNumber) {
        this.kodeDosen = kodeDosen;
        this.name = name;
        this.email = email;
        this.access = access;
        this.phoneNumber = phoneNumber;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
