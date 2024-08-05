package com.example.ecom.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Transaction {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int userid;
    private String planname;
    private String description;
    private double price;

    public Transaction(){}

    public Transaction(int id, int userid, String planname, String description, double price) {
        this.id = id;
        this.userid = userid;
        this.planname = planname;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
