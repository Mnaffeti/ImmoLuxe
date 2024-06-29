package com.example.immoluxe.Controller;

import com.example.immoluxe.Entity.RDV;
import com.example.immoluxe.Service.IRDVService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class RDVController {
    IRDVService irdvService;
    @PostMapping(path = "/rdv")
    RDV ajouterRdv(@RequestBody RDV rdv) {
        return irdvService.AddRdv(rdv);

    }
    @GetMapping("/rdv")
    public List<RDV> getAllRdv() {
        return irdvService.findAll();
    }

    @GetMapping("/rdv/{id}")
    public RDV getRdvById(@PathVariable int id) {
        return irdvService.findById(id);
    }

    @PutMapping("/rdv/{id}")
    public RDV updateRdv(@PathVariable int id, @RequestBody RDV rdv) {
        return irdvService.updateRdv(id, rdv);
    }

    @DeleteMapping("/rdv/{id}")
    public void deleteRdv(@PathVariable int id) {
        irdvService.deleteById(id);
    }
}