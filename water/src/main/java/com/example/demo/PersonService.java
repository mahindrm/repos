package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private Repository repository;



    public Person createperson(Person person)
    {
        return repository.save(person);
    }

    public List<Person> getdetails() {

        return repository.findAll();
    }

    public Optional<Person> getbyid(Long id) throws Usernotfoundexception {
        Optional<Person> person =  repository.findById(id);
        if(person.isPresent())
        {
            return person;
        }
        else
        {
            throw new Usernotfoundexception("User not found with id"+id);
        }


    }

    public Person getbyput(Long id, Person person) throws Usernotfoundexception {
        Person person2 = repository.findById(id)
                .orElseThrow(() -> new Usernotfoundexception("Entity not found with id " + id));

            person2.setId(person.getId());
            person2.setAddress(person.getAddress());
            person2.setName(person.getName());
            person2.setAge(person.getAge());
            person2.setEmail(person.getEmail());
            person2.setAddresses(person.getAddresses());
            return repository.save(person2);


    }

    public String getbydelete(Long id) {
        Person person2 = repository.findById(id).orElse(null);
        if(person2!=null) {
            repository.delete(person2);

        }
        return "Deleted Successfully";
    }
}
