package com.example.meteoepal;

public class SchoolInfo {
    private String name;
    private String location;
    private String telephone;

    public SchoolInfo(String sname, String slocation, String stelephone) {
        this.name = sname;
        this.location = slocation;
        this.telephone = stelephone;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }
}
