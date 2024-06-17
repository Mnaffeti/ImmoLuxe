package com.example.immoluxe.Controller;

import com.example.immoluxe.Entity.Contrat;
import com.example.immoluxe.Entity.TypeContrat;
import com.example.immoluxe.Service.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ContratController {
    IContratService contratService;
    @PostMapping(path="/contrat")
    Contrat ajouterContrat(@RequestBody Contrat contrat){
            return contratService.AddContrat(contrat);
    }
    @DeleteMapping("/contrat")
    Contrat deleteContrat(@RequestBody Contrat contrat){
            return contratService.deleteContrat(contrat);
    }
    @DeleteMapping("/contrat/{id}")
    boolean deleteContratByID(@PathVariable Long id){return contratService.deleteContratById(id);}
    @GetMapping("/contrat/{id}")
    ResponseEntity<Contrat> getContratById(@PathVariable Long id) {
        Contrat contrat = contratService.GetContratById(id);
        return ResponseEntity.ok(contrat);
    }

    @GetMapping("/contrat/type/{type}")
    ResponseEntity<List<Contrat>> getContratsByType(@PathVariable TypeContrat type) {
        List<Contrat> contrats = contratService.GetAllContratByType(type);
        return ResponseEntity.ok(contrats);
    }
    @GetMapping(path="/contrat")
    ResponseEntity<List<Contrat>> getAllContrat(){
        List<Contrat> contrats =contratService.GetAllContrat();
        return ResponseEntity.ok(contrats);}
   @GetMapping(path="/contrat/getType/{id}")
    TypeContrat getTypeContrat(@PathVariable Long id){return contratService.GetContratTypeById(id);}
    @GetMapping(path="/contrat/getByType/{type}")
    List<Contrat> getAllContratbyType(@PathVariable TypeContrat type){return contratService.GetAllContratByType(type);}
    @PutMapping(path="/contrat")
    Contrat updateContrat(@RequestBody Contrat contrat){return contratService.UpdateContrat(contrat);}
}
