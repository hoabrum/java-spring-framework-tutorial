package com.jpademo.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookPK implements Serializable {

    private String title;
    private String author;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookPK bookPK = (BookPK) o;
        return Objects.equals(title, bookPK.title) && Objects.equals(author, bookPK.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
