package com.example.immoluxe.Controller;

import com.example.immoluxe.Entity.Property;
import com.example.immoluxe.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    private static final String UPLOAD_DIR = "uploads/";

    //get all properties
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/properties")
    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }

    //create property
    @PostMapping("/properties")
    public Property createProperty(@RequestParam("type") String type,
                                   @RequestParam("bedrooms") int bedrooms,
                                   @RequestParam("price") double price,
                                   @RequestParam("bathrooms") int bathrooms,
                                   @RequestParam("area") int area,
                                   @RequestParam("description") String description,
                                   @RequestParam("photo") MultipartFile photo) throws IOException {

        Property property = new Property();
        property.setType(type);
        property.setBedrooms(bedrooms);
        property.setPrice(price);
        property.setBathrooms(bathrooms);
        property.setArea(area);
        property.setDescription(description);

        // Handle file saving
        if (!photo.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, photo.getBytes());
            String photoUrl = "/api/v1/clicks/files/" + fileName;
            property.setPhotoUrl(photoUrl);
        }

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
    public ResponseEntity<Property> updatePropertyByID(@PathVariable Long id,
                                                       @RequestParam("type") String type,
                                                       @RequestParam("bedrooms") int bedrooms,
                                                       @RequestParam("price") double price,
                                                       @RequestParam("bathrooms") int bathrooms,
                                                       @RequestParam("area") int area,
                                                       @RequestParam("description") String description,
                                                       @RequestParam("photo") MultipartFile photo) throws IOException {

        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property with id "+id+" does not exist"));

        property.setType(type);
        property.setBedrooms(bedrooms);
        property.setPrice(price);
        property.setBathrooms(bathrooms);
        property.setArea(area);
        property.setDescription(description);

        // Handle file saving
        if (!photo.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, photo.getBytes());
            String photoUrl = "/api/v1/files/" + fileName;
            property.setPhotoUrl(photoUrl);
        }

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

    // endpoint to serve files



}
