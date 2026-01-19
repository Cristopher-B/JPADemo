package com.example.JPADemo.repository;

import com.example.JPADemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    // No es necesario agregar métodos por ahora,
    // JpaRepository ya provee findAll, findById, save, deleteById, etc.
}
