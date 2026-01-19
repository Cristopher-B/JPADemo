package com.example.JPADemo.controller;

import com.example.JPADemo.model.Person;
import com.example.JPADemo.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demoJPA")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getAll() {
        return personService.getPersons();
    }

    @GetMapping("/personas/{id}")
    public Person getById(@PathVariable Long id){
        return personService.findPerson(id);
    }

    @PostMapping("/persons")
    public String save(@RequestBody Person person){
        personService.savePerson(person);
        return "Persona creada correctamente";
    }

    @PatchMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person){
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/persons/{id}")
    public String delete(@PathVariable Long id){
        personService.deletePerson(id);
        return "Persona eliminada correctamente";
    }
}
