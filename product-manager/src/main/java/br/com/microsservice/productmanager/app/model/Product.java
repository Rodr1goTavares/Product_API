package br.com.microsservice.productmanager.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb-product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private boolean available;
    public Product() {}
    public Product(String name, String description, double price, boolean available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }
}
