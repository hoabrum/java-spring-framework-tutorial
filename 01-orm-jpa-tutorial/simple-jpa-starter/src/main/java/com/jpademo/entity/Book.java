package com.jpademo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "books", schema = "dbo")
@Entity
public class Book {

    //@Id
    @EmbeddedId
    private BookPK id;

    private double price;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    public BookPK getId() {
        return id;
    }

    public void setId(BookPK id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
