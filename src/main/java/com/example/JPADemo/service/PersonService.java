package com.example.JPADemo.service;

import com.example.JPADemo.model.Person;
import com.example.JPADemo.repository.IPersonRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PersonService implements IPersonService {

    private final IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> listaPersonas = personRepository.findAll();
        return listaPersonas;
    }

    @Override
    public Person findPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person updatePerson(Long id, Person datosNuevos) {
        //Buscar persona existente por id
        Person personaExistente = personRepository.findById(id).orElse(null);
        if (personaExistente == null) {
            return null; //No existe
        }
        //Actualizar solo los campos con valor
        if (datosNuevos.getName() != null) {
            personaExistente.setName(datosNuevos.getName());
        }
        if (datosNuevos.getLastName() != null) {
            personaExistente.setLastName(datosNuevos.getLastName());
        }
        if (datosNuevos.getAge() != 0) {
            personaExistente.setAge(datosNuevos.getAge());
        }
        //Guardar y retornar
        return personRepository.save(personaExistente);
    }
}
