package com.example.exercise2.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // atributos
    private Long id;
    private String marca;
    private Double price;
    private LocalDate releaseDate;

    // constructores

    public Laptop() {
    }

    public Laptop(Long id, String marca, Double price, LocalDate releaseDate) {
        this.id = id;
        this.marca = marca;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    // toString


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                '}';
    }
}

