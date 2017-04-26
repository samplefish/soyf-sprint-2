package com.example.airuser.soyf10;

/**
 * Created by William on 3/22/2017.
 */

public class User {
    String name, username, password;
    int age;

    public User(String name, int age, String username, String password){
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){


        this.username = username;
        this.password = password;
    }

}
