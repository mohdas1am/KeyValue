package com.example.ChandrettanteCanteen.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Student {

    @Id
    private String sid;

    private String password;

    private String name;

    private Double credit = 0.0;

    private Double creditThreshold = 150.0;

    public Student() {
    }


    public Student(String sid, String password, String name, Double credit, Double creditThreshold) {
        this.sid = sid;
        this.password = password;
        this.name = name;
        this.credit = credit;
        this.creditThreshold = creditThreshold;
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getCreditThreshold() {
        return creditThreshold;
    }

    public void setCreditThreshold(Double creditThreshold) {
        this.creditThreshold = creditThreshold;
    }
}
