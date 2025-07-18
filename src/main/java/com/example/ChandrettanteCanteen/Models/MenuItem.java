package com.example.ChandrettanteCanteen.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @Column(name = "mid")
    private String Mid;

    private String itemName;

    private Double price;

    private Boolean available = true;  // Item visibility for ordering

    // Getters and Setters

    public MenuItem() {
    }

    public MenuItem(String  id, String itemName, Double price, Boolean available) {
        this.Mid = id;
        this.itemName = itemName;
        this.price = price;
        this.available = available;
    }

    public String getId() {
        return Mid;
    }

    public void setId(String id) {
        this.Mid = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}

