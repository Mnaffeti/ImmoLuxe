package com.example.immoluxe.Entity;

import com.example.immoluxe.Common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contrat extends BaseEntity {
   // @Id
   // @GeneratedValue
   // Long idContrat;

/*
    @ManyToOne
    @JoinColumn(name = "id_client")
    User client;

    @ManyToOne
    @JoinColumn(name = "id_agent")
    User agent;
*/
    @ManyToOne
    @JoinColumn(name = "id_property")
    Property property;

    @Enumerated(EnumType.STRING)
    TypeContrat typeContrat;

    Date dateDebut;
    Date dateFin;
    double montant;
}

