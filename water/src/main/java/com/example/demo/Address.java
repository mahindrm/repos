package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private long address_id;

private String City;
private String state;
private String zipcode;

@ManyToOne
@JoinColumn(name="personid")
@JsonBackReference
private Person person;
}


