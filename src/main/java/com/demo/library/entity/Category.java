package com.demo.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
   private List<Book> books = new ArrayList<>();

    public Category(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
