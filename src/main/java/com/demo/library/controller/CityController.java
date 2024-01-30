package com.demo.library.controller;

import com.demo.library.entity.City;
import com.demo.library.entity.Zipcode;
import com.demo.library.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @PostMapping()
    public City create(@RequestBody City zipcode) {
        return cityRepository.save(zipcode);
    }

    @GetMapping()
    public List<City> getAll(){
        Iterable<City> all = cityRepository.findAll();
        List<City> result = new ArrayList<>();
        all.iterator().forEachRemaining(result::add);
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<City> byId = cityRepository.findById(id);
        cityRepository.delete(byId.get());
    }
}