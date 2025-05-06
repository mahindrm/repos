package com.example.demo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Entity
@Data
@Table(name="table1")
@NoArgsConstructor
public class Person  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be null")
    private String name;

    @NotEmpty(message = "email address cannot be null")
    private List<String> email;

    @Min(value=16, message="minimum age should be 16")
    @Max(value=60 ,message="maximum age should be 60")
    private int age;

    @Size( min = 10, max = 100,
            message = "Address should have a length between 10 and 100 characters.")
    private String address;

    @Setter
    @Getter
    @OneToMany(mappedBy = "person" ,cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<Address> addresses;

}
