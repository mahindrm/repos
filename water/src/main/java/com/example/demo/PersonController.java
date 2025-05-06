package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/water")
public class PersonController {

    @Autowired
    private PersonService service;



    @PostMapping("/addPerson")
    public ResponseEntity<Person> createperson(@RequestBody @Valid Person person)
    {

        return new ResponseEntity<>(service.createperson(person), HttpStatus.OK);

    }
    @GetMapping("/person")
    public ResponseEntity<List<Person>> getdetails(){

        return ResponseEntity.ok(service.getdetails());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getbyid(@PathVariable Long id) throws Usernotfoundexception
    {
         return ResponseEntity.ok(service.getbyid(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Person> getbyput(@PathVariable Long id ,@RequestBody Person person) throws Usernotfoundexception
    {

        return ResponseEntity.ok(service.getbyput(id,person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> getbydelete(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getbydelete(id));
    }

}
