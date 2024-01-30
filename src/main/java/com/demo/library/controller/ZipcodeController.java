package com.demo.library.controller;

import com.demo.library.entity.City;
import com.demo.library.entity.Zipcode;
import com.demo.library.repository.CityRepository;
import com.demo.library.repository.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zipcodes")
public class ZipcodeController {

    @Autowired
    private ZipcodeRepository zipcodeRepository;

    @Autowired
    private CityRepository cityRepository;

    @PostMapping()
    public Zipcode create(@RequestBody Zipcode zipcode) {
        return zipcodeRepository.save(zipcode);
    }

    @GetMapping()
    public List<Zipcode> getAll(){
        Iterable<Zipcode> all = zipcodeRepository.findAll();
        List<Zipcode> result = new ArrayList<>();
        all.iterator().forEachRemaining(result::add);
        return result;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Zipcode> byId = zipcodeRepository.findById(id);
        zipcodeRepository.delete(byId.get());
    }

    @PutMapping("{zipcodeId}/{cityId}")
    public void assignCity(@PathVariable Long zipcodeId,@PathVariable Long cityId){
        Zipcode zipcode = zipcodeRepository.findById(zipcodeId).get();
        City city = cityRepository.findById(cityId).get();
        zipcode.setCity(city);
        zipcodeRepository.save(zipcode);
    }

    @PutMapping("{zipcodeId}")
    public void detachCity(@PathVariable Long zipcodeId){
        Zipcode zipcode = zipcodeRepository.findById(zipcodeId).get();
        zipcode.setCity(null);
        zipcodeRepository.save(zipcode);
    }
}