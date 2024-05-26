package com.example.immoluxe.Repository;

import com.example.immoluxe.Entity.Contrat;
import com.example.immoluxe.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface PropertyRepository extends JpaRepository<Property, Integer>
{
}
