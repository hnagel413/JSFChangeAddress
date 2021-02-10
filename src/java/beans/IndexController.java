package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;
import models.Address;

@Named(value = "indexController")
@SessionScoped
public class IndexController implements Serializable {
    
    @PersistenceUnit EntityManagerFactory emf;
    @PersistenceContext EntityManager em;
    @Resource UserTransaction ut;    
    
    private Address human = new Address();
    private List<Address> humans = new ArrayList();

    public IndexController() {
    }
    
    public List<Address> getHumans(){
        try {
            CriteriaQuery crit = em.getCriteriaBuilder().createQuery();
            crit.select(crit.from(Address.class));
            Query qr = em.createQuery(crit);
            return humans = qr.getResultList();
        } catch (Exception e) {
        }
        return humans;
    }
    
    public void add(){
        try {
            ut.begin();
            em.persist(human);
            ut.commit();
            human = new Address();
        } catch (Exception exe) {
            try {
                ut.rollback();
            } catch (Exception e) {
            }
        }
    }    
    
    public String getFirstName() {
        return human.getFirstname();
    }

    public void setFirstName(String firstName) {
        human.setFirstname(firstName);
    }

    public String getLastName() {
        return human.getLastname();
    }

    public void setLastName(String lastName) {
        human.setLastname(lastName);
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
