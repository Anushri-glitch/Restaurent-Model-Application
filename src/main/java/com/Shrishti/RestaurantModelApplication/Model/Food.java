package com.Shrishti.RestaurantModelApplication.Model;

import jakarta.persistence.*;

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;
    private String foodName;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurent_name")
    private Restaurent restaurent;
}
