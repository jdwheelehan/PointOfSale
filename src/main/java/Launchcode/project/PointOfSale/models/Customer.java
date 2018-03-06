package Launchcode.project.PointOfSale.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer customerId;

    private String customerName;

    private String gameTitle;

    private String customernumber;

    public Customer() {
    }

    public Customer(String customerName, String gameTitle, String customernumber) {

        this.customerName = customerName;
        this.gameTitle = gameTitle;
        this.customernumber = customernumber;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }
}