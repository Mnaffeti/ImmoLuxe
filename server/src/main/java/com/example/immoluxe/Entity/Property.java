package com.example.immoluxe.Entity;

import com.example.immoluxe.Entity.Adresse;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue
    Long IdProperty ;
    @ManyToOne
    @JoinColumn(name = "id_proprietaire")
    User proprietaire;

    @Enumerated(EnumType.STRING)
    TypeProperty type ;
    @Embedded  // Ajout de l'annotation @Embedded pour indiquer qu'il s'agit d'une entité imbriquée
    Adresse adresse ;
    double price;
    int bedrooms;
    int bathrooms;
    double area;
    String description;
    @Enumerated(EnumType.STRING)
    StatusProperty status;
    //Photos  / IdAgent
}
