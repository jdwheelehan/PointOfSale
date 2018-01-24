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

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Field must not be empty")
    private String address;

    @NotNull
    @Size(min=1, message = "Field must not be empty")
    private String phoneNumber;

    @NotNull
    @Size(min=1, message = "Field must not be empty")
    private Integer password;

    private Date dateOfHire = new Date();

    public User() {
    }

    public User(String name, String address, String phoneNumber, Integer password) {

        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;

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

    public Date getDateOfHire() {
        return dateOfHire;
    }


}
