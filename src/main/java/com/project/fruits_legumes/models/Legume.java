package com.project.fruits_legumes.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "legumes")
public class Legume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String name;

    @Column(name = "origine")
    private String origin;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "saison")
    private List<String> season;

    @Column(name = "price_per_kg")
    private BigDecimal pricePerKg;

    @Column(name = "quantite")
    private String quantity;

    // Constructeur par défaut
    public Legume() {
    }

    public Legume(String name, String origin, List<String> season, BigDecimal pricePerKg, String quantity) {
        this.name = name;
        this.origin = origin;
        this.season = season;
        this.pricePerKg = pricePerKg;
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<String> getSeason() {
        return season;
    }

    public void setSeason(List<String> season) {
        this.season = season;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(BigDecimal pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Legume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", season=" + season +
                ", pricePerKg=" + pricePerKg +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
