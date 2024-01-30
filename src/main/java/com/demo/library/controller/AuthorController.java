package com.demo.library.controller;

import com.demo.library.entity.Author;
import com.demo.library.entity.Zipcode;
import com.demo.library.repository.AuthorRepository;
import com.demo.library.repository.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ZipcodeRepository zipcodeRepository;

    @PostMapping()
    public Author create(@RequestBody Author author) {
        Iterable<Zipcode> all = zipcodeRepository.findAll();
        if (all.iterator().hasNext()){
            author.setZipcode(all.iterator().next());
        }
        return authorRepository.save(author);
    }

    @GetMapping()
    public List<Author> getAll(){
        Iterable<Author> all = authorRepository.findAll();
        List<Author> result = new ArrayList<>();
        all.iterator().forEachRemaining(result::add);
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Author> byId = authorRepository.findById(id);
        authorRepository.delete(byId.get());
    }
}