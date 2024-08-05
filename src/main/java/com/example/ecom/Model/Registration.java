package com.example.ecom.Model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigInteger;

@Table
@Data
@Entity
public class Registration {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    private String email;
    private BigInteger number;


    public Registration(){}

    public Registration(String name, String email, BigInteger number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }
}
