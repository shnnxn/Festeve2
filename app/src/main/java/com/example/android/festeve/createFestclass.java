package com.example.android.festeve;


import org.w3c.dom.Text;

public class createFestclass {

    public String fest_name;
    public String college;
    public String city;
    public String s_date;

    public createFestclass() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters

    public String getFestName() {
        return fest_name;
    }

    public void setFestName(String fest_name) {
        this.fest_name = fest_name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return s_date;
    }

    public void setDate(String s_date) {
        this.s_date = s_date;
    }
}