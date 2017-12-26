package com.example.customadapterf17.Models;

import com.example.customadapterf17.Enums.Gender;

public class Contact {

    private String name;
    private String phone;
    private Gender gender;
    private int image;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name, String phone, Gender gender, int image) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.image = image;
    }

    // SETTER METHODS

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setImage(int image) {
        this.image = image;
    }

    //GETTER METHODS

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    public int getImage() {
        return image;
    }
}













