package com.github.Eduardotxteatro.controllers;

import com.github.Eduardotxteatro.services.PersonServices;
import com.github.Eduardotxteatro.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //Alteração do verbo @RequestMapping para o GetMapping (forma correta)
        public List<Person> findAll(){
        return services.findAll();
    }

    @GetMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE) //Alteração do verbo @RequestMapping para o GetMapping (forma correta)

    public Person findById(@PathVariable("id") Long id){
        return services.findByID(id);

    }
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE, //Alteração do verbo @RequestMapping para o PostMapping (forma correta)
        produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Person create(@RequestBody Person person){
        return services.create(person);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE, //Alteração do verbo @RequestMapping para o PutMapping (forma correta)
        produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Person update(@RequestBody Person person){
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}") //Alteração do verbo @RequestMapping para o DeleteMapping (forma correta)

    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        services.delete(id);
        return ResponseEntity.noContent().build(); //Para retornar o status code correto de 200 para 204
    }



}
