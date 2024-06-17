package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.Contrat;
import com.example.immoluxe.Entity.TypeContrat;
import com.example.immoluxe.Entity.User;
import com.example.immoluxe.Repository.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ContratServiceImp implements IContratService {
    ContratRepository contratRep ;
    @Override
    public Contrat AddContrat(Contrat contrat) {
        return contratRep.save(contrat);
    }

    @Override
    public Contrat GetContratById(Long id) {
        return contratRep.findById(id).get();
    }

    @Override
    public List<Contrat> GetAllContrat() {
        return contratRep.findAll();
    }
    @Override
    public Contrat deleteContrat(Contrat contrat) {
        contratRep.delete(contrat);
        return contratRep.findById(Long.valueOf(contrat.getId())).orElse(null);
    }
    @Override
    public TypeContrat GetContratTypeById(Long id) {
        return contratRep.findById(id).get().getTypeContrat();
    }

    @Override
    public List<Contrat> GetAllContratByType(TypeContrat type) {
        // Récupérer tous les contrats
        List<Contrat> allContrats = contratRep.findAll();

        // Filtrer les contrats par type
        List<Contrat> contratsByType = allContrats.stream()
                .filter(contrat -> contrat.getTypeContrat() == type)
                .collect(Collectors.toList());

        return contratsByType;
    }

    @Override
    public Contrat UpdateContrat(Contrat contrat ) {
        return contratRep.save(contrat);
    }
    /*
    @Override
    public User GetClientByIdContrat(Long id) {
        return contratRep.findById(id).get().getClient();
    }
    /*
    @Override
    public User GetProprietaireByIdContrat(Long id) {
        return contratRep.findById(id).get().getProperty().getProprietaire();
    }

    @Override
    public User GetAgentByIdContrat(Long id) {
        return contratRep.findById(id).get().getAgent();
    }

     */
    @Override
    public boolean deleteContratById(Long id) {
        return contratRep.findById(id).map(contrat -> {
            contratRep.delete(contrat);
            return true;
        }).orElse(false);
    }
}
