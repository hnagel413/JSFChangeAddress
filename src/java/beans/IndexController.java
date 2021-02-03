package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import models.Human;

@Named(value = "indexController")
@SessionScoped
public class IndexController implements Serializable {
    
    private Human human = new Human();
    private List<Human> humans = new ArrayList();

    public IndexController() {
    }
    
    public List<Human> getHumans(){
        return humans;
    }
    
    public void add(){
        if(human.isLegal()){
            humans.add(human);
            human = new Human();
        }
    }    
    
    public String getFirstName() {
        return human.getFirstName();
    }

    public void setFirstName(String firstName) {
        human.setFirstName(firstName);
    }

    public String getLastName() {
        return human.getLastName();
    }

    public void setLastName(String lastName) {
        human.setLastName(lastName);
    }

    public String getAddress() {
        return human.getAddress();
    }

    public void setAddress(String address) {
        human.setAddress(address);
    }

    public String getCode() {
        return human.getCode();
    }

    public void setCode(String code) {
        human.setCode(code);
    }

    public String getCity() {
        return human.getCity();
    }

    public void setCity(String city) {
       human.setCity(city);
    }

    public String getEmail() {
        return human.getEmail();
    }

    public void setEmail(String email) {
       human.setEmail(email);
    }

    public String getTitle() {
        return human.getTitle();
    }

    public void setTitle(String title) {
        human.setTitle(title);
    }

    public String getDate() {
        return human.getDate();
    }

    public void setDate(String date) {
        human.setDate(date);
    }
    
}
