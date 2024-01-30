package com.demo.library.controller;

import com.demo.library.entity.Author;
import com.demo.library.entity.Book;
import com.demo.library.entity.Category;
import com.demo.library.entity.Zipcode;
import com.demo.library.repository.AuthorRepository;
import com.demo.library.repository.BookRepository;
import com.demo.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping()
    public Book create(@RequestBody Book author) {
        Iterable<Author> all = authorRepository.findAll();
        if (all.iterator().hasNext()){
            author.addAuthor(all.iterator().next());
        }
        Iterable<Category> categories = categoryRepository.findAll();
        if (categories.iterator().hasNext()){
            author.setCategory(categories.iterator().next());
        }
        return bookRepository.save(author);
    }

    @GetMapping()
    public List<Book> getAll(){
        Iterable<Book> all = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        all.iterator().forEachRemaining(result::add);
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        bookRepository.delete(byId.get());
    }
}