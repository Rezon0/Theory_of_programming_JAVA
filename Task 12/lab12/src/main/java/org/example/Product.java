package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id" ) Long id ;
}
