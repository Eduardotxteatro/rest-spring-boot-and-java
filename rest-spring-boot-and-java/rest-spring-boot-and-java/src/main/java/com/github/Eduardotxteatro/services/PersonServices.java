package com.github.Eduardotxteatro.services;

import com.github.Eduardotxteatro.exception.ResourceNotFoundException;
import com.github.Eduardotxteatro.model.Person;
import com.github.Eduardotxteatro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;




    public List<Person> findAll(){

        logger.info("Finding all People!");

        return repository.findAll();


    }



    public Person findByID(Long id){

        logger.info("Finding one Person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    }

    public Person create(Person person){

        logger.info("Creating one Person!");

        return repository.save(person);
    }
    public Person update(Person person){
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                        .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
        person.setId(counter.incrementAndGet());

        entity.setFistName(person.getFistName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }


}
