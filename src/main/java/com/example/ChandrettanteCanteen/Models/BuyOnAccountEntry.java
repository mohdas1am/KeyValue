package com.example.ChandrettanteCanteen.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "buy_on_account")
public class BuyOnAccountEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    private Double amount;

    private String description;

    private LocalDateTime dateTime = LocalDateTime.now();

    public BuyOnAccountEntry() {
    }

    public BuyOnAccountEntry(Long id, Student student, Double amount, String description, LocalDateTime dateTime) {
        this.id = id;
        this.student = student;
        this.amount = amount;
        this.description = description;
        this.dateTime = dateTime;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
