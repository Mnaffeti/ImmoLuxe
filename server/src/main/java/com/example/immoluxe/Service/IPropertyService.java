package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.Property;
import com.example.immoluxe.Entity.StatusProperty;
import com.example.immoluxe.Entity.TypeProperty;
import com.example.immoluxe.Entity.User;

import java.util.List;

    public interface IPropertyService{
        Property AddProperty(Property property);
        Property GetPropertyById(Long id);
        StatusProperty GetPropertyStatusById(Long id);
        TypeProperty GetPropertyTypeById(Long id);
        User GetProprietaireByIdProperty(Long id);
        List<Property> GetAllPropertyByType(TypeProperty type);
        Property UpdateProperty(Property property);
        void DeletePropertyById(Long id);
    }
