package com.example.JPADemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastName;
    private int age;

    @Repository
    public interface IPersonRepository extends JpaRepository <Person, Long>{   //Necesito un repositorio para la entidad Person
    }
}
