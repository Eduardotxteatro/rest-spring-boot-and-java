package com.github.Eduardotxteatro;

import com.github.Eduardotxteatro.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();

        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;

    }



    public Person findByID(String id){

        logger.info("Finding all People!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Eduardo");
        person.setLastName("Texiera");
        person.setAddress("Lisboa - Portugal");
        person.setGender("Homem");

        return person;
    }

    public Person create(Person person){

        logger.info("Creating one Person!");

        return person;
    }
    public Person update(Person person){

        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Homem");

        return person;
    }

}
