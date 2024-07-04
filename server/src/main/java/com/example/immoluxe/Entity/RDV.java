package com.example.immoluxe.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.example.immoluxe.Common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RDV extends BaseEntity {
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dateHeure;
    private String statut;
}
