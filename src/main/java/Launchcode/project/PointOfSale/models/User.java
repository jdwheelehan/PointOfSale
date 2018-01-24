package Launchcode.project.PointOfSale.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int employeeId;

    private String dateOfHire;

    private String name;


    private String address;


    private String phoneNumber;


    private Integer password;


    private String clearanceLevel;

    public User() {
    }

    public User(String name, String address, String phoneNumber, Integer password, String clearanceLevel, String dateOfHire) {

        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.clearanceLevel = clearanceLevel;
        this.dateOfHire = dateOfHire;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getDateOfHire() {
        return dateOfHire;
    }

    public String getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(String clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }
}
