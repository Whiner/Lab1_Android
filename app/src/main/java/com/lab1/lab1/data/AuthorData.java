package com.lab1.lab1.data;

public class AuthorData {
    private String name;
    private String surname;
    private int variant;
    private String group;

    public AuthorData() {
    }

    public AuthorData(String name, String surname, int variant, String group) {
        this.name = name;
        this.surname = surname;
        this.variant = variant;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getVariant() {
        return variant;
    }

    public void setVariant(int variant) {
        this.variant = variant;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
