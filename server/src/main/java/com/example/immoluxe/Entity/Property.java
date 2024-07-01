package com.example.immoluxe.Entity;

import com.example.immoluxe.Common.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property extends BaseEntity {

 private String adresse;
 private String type;
 private double price;
 private int bedrooms;
 private int bathrooms;
 private double area;
 private String description;

}