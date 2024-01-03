package com.soCompany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id @Getter @Setter
    @GeneratedValue
    Long id;

    @Getter @Setter
    String title, author, genre;

    @Getter @Setter
    Integer pages;


}
