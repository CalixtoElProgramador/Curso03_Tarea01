package com.example.curso03_tarea01;

import java.io.Serializable;

public class User implements Serializable {

    private final String name;
    private final String birthday;
    private final String phone;
    private final String email;
    private final String description;

    public User(String name, String phone, String email, String birthday, String description) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

}
