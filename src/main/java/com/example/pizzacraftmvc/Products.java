package com.example.pizzacraftmvc;



import jakarta.persistence.*;

import java.util.List;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    @Column(unique = true)
    private String product;

    public Long getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public String getProduct() {
        return product;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setProduct(String product) {
        this.product = product;

    }
}
