package models;

import java.io.Serializable;

public class Human implements Serializable{
    
    private String firstName, lastName, address, code, city, email, title, date;

    public Human() {
    }

    public Human(String firstName, String lastName, String address, String code, String city, String email, String title, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.code = code;
        this.city = city;
        this.email = email;
        this.title = title;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public boolean isLegal(){
        return firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0
                && date != null && date.length() > 0;
    }
    
}
