package com.skankhunt.s7_telematics.data;

/**
 * Created by wupengcong on 2018/5/31.
 */

public final class User {

    private String username;

    private String password;

    private String carnum;

    private String phonenum;


    public User(String username, String password, String carnum, String phonenum) {
        this.username = username;
        this.password = password;
        this.carnum = carnum;
        this.phonenum = phonenum;
    }

    public User(String username, String password, String carnum) {
        this.username = username;
        this.password = password;
        this.carnum = carnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", carnum='" + carnum + '\'' +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}
