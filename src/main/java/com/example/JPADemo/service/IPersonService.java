package com.example.JPADemo.service;

import com.example.JPADemo.model.Person;

import java.util.List;

public interface IPersonService {

    //metodo para traer todas las personas
    public List<Person> getPersons();

    //metodo para traer una persona en específico
    public Person findPerson(Long id);

    //metodo para guardar una persona
    public void savePerson(Person person);

    //metodo para borrar una persona
    public void deletePerson(Long id);

    //metodo para actualizar una persona
    public Person updatePerson(Long id, Person datosNuevos);
}
