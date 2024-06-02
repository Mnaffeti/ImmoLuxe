package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.Contrat;
import com.example.immoluxe.Entity.TypeContrat;
import com.example.immoluxe.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IContratService {
    Contrat AddContrat(Contrat contrat);
    Contrat GetContratById(Long id);
    List<Contrat> GetAllContrat();
    TypeContrat GetContratTypeById(Long id);
    List<Contrat> GetAllContratByType(TypeContrat type);
    Contrat UpdateContrat(Contrat contrat);
    User GetClientByIdContrat(Long id);
    User GetProprietaireByIdContrat(Long id);
    User GetAgentByIdContrat(Long id);
    boolean deleteContratById(Long id);
    Contrat deleteContrat(Contrat contrat);
}
