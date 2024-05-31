package com.example.immoluxe.Controller;

import com.example.immoluxe.Entity.Contrat;
import com.example.immoluxe.Service.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
            return contratService.deletebloc(contrat);
        }
}
