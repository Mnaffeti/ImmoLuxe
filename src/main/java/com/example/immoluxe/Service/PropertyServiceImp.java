package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.Property;
import com.example.immoluxe.Entity.StatusProperty;
import com.example.immoluxe.Entity.TypeProperty;
import com.example.immoluxe.Entity.User;
import com.example.immoluxe.Repository.PropertyRepository;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class PropertyServiceImp implements IPropertyService {

    PropertyRepository propertyRepository;
    @Override
    public Property AddProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property GetPropertyById(Long id) {
        return null;
    }

    @Override
    public StatusProperty GetPropertyStatusById(Long id) {
        return null;
    }

    @Override
    public TypeProperty GetPropertyTypeById(Long id) {
        return null;
    }

    @Override
    public User GetProprietaireByIdProperty(Long id) {
        return null;
    }

    @Override
    public List<Property> GetAllPropertyByType(TypeProperty type) {
        return List.of();
    }

    @Override
    public Property UpdateProperty(Property property) {
        return null;
    }

    @Override
    public void DeletePropertyById(Long id) {

    }
}
