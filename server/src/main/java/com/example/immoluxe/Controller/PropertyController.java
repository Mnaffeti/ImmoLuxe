package com.example.immoluxe.Controller;

import com.example.immoluxe.Entity.Contrat;
import com.example.immoluxe.Entity.Property;
import com.example.immoluxe.Service.IContratService;
import com.example.immoluxe.Service.IPropertyService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PropertyController {
    IPropertyService propertyService;
    @PostMapping(path="/property")
    Property ajouterProperty(@RequestBody Property property){

        return propertyService.AddProperty(property);
    }
    @GetMapping("/property")
    public List<Property> ListeOfProperties(){
        return propertyService.GetAllProperties();
    }
}
