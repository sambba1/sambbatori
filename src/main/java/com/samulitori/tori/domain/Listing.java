package com.samulitori.tori.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listing_id;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Listing() {}


    public Listing(String name, double price, Category category, User user){
        super();
        this.name = name;
        this.price = price;
        this.category = category;
        this.user = user;
    }



    public Long getListing_id() {
        return listing_id;
    }

    public void setListing_id(Long listing_id) {
        this.listing_id = listing_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }


}