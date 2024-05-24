package com.example.immoluxe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @EqualsAndHashCode
// @ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long IdUser ;
    String FirstName ;
    String LastName ;
    String Mail ;
    String Pwd ;
    LocalDate DateBirth ;
    @Enumerated(EnumType.STRING)
    Role role ;


}
