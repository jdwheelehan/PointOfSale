package Launchcode.project.PointOfSale.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item {

    @Id
    @NotNull
    private Long Sku;

    @NotNull
    @Size(max=35)
    private String name;

    @NotNull
    private Integer quantity;

    public Item() {
    }

    public Item(Long sku, String name, Integer quantity) {
        Sku = sku;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getSku() {
        return Sku;
    }

    public void setSku(Long sku) {
        Sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
