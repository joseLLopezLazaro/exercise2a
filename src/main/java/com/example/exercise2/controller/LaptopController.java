package com.example.exercise2.controller;

import com.example.exercise2.entities.Laptop;
import com.example.exercise2.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private LaptopRepository  laptopRepository;
    private final Logger log = LoggerFactory.getLogger((LaptopController.class));

    public LaptopController(){}

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //TODOS LAPTOP
    //http://localhost:8080/api/laptops

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Busrcar un Laptop por clave primaria")
    // Buscar un solo libro en base de datos segun su id
    public ResponseEntity<Laptop> findById(@ApiParam("Clave tipo Long") @PathVariable Long id ) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent()) {
            return  ResponseEntity.ok(laptopOpt.get());
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/laptop")
    public ResponseEntity<Object> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-agent"));
        if(laptop.getId()!= null) {
            log.warn("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if(laptop.getId() == null) {
            log.warn("trying to update a book");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())) {
            log.warn("trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptop/{id}")
    public  ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if(!laptopRepository.existsById(id)) {
            log.warn("trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/(api/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        log.info ("Deleting all books");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
