package com.example.immoluxe.Controller;

import com.example.immoluxe.Entity.Property;
import com.example.immoluxe.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    //get all properties
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/properties")
    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }

    //create property
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/properties")
    public Property createProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    // get property by id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/properties/{id}")
    public ResponseEntity<Property> getPropertyByID(@PathVariable Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property with id "+id+" does not exist"));
        return ResponseEntity.ok(property);
    }

    //update property
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/properties/{id}")
    public ResponseEntity<Property> updatePropertyByID(@PathVariable Long id, @RequestBody Property propertyDetails){
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property with id "+id+" does not exist"));

        property.setAdresse(propertyDetails.getAdresse());
        property.setType(propertyDetails.getType());
        property.setPrice(propertyDetails.getPrice());
        property.setBedrooms(propertyDetails.getBedrooms());
        property.setBathrooms(propertyDetails.getBathrooms());
        property.setArea(propertyDetails.getArea());
        property.setDescription(propertyDetails.getDescription());

        Property updatedProperty = propertyRepository.save(property);

        return ResponseEntity.ok(updatedProperty);
    }

    //delete property
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProperty(@PathVariable Long id){
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property with id "+id+" does not exist"));

        propertyRepository.delete(property);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}