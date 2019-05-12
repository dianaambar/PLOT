package com.example.android.plot.Model;

public class User {
    private String first_name;
    private String last_name;
    private String password;
    private String confirm_password;
    private String username;
    private String email_address;

    public User(String first_name, String last_name, String password, String confirm_password, String username, String email_address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.confirm_password = confirm_password;
        this.username = username;
        this.email_address = email_address;
    }

    public User() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
}
