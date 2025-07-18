package com.example.ChandrettanteCanteen.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    private String itemName;

    private Double itemPrice;

    private String paymentType;  // pay_now or on_account

    private Boolean isPaid = false;

    private LocalDateTime orderTime = LocalDateTime.now();

    private String orderNumber;  // Unique daily order number (Optional but useful)

    public Order() {
    }

    public Order(Long id, Student student, String itemName, Double itemPrice, String paymentType, Boolean isPaid, LocalDateTime orderTime, String orderNumber) {
        this.id = id;
        this.student = student;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.paymentType = paymentType;
        this.isPaid = isPaid;
        this.orderTime = orderTime;
        this.orderNumber = orderNumber;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
