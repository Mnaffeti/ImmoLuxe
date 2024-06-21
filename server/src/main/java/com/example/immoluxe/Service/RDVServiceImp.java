package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.RDV;
import com.example.immoluxe.Repository.RDVRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RDVServiceImp implements IRDVService {
    RDVRepository rdvRepo;
    @Override
    public RDV AddRdv(RDV rdv) {
        return rdvRepo.save(rdv);
    }
    public List<RDV> getAllRdvs() {
        return rdvRepo.findAll();
    }

    @Override
    public List<RDV> getRdvById(Long id) {
        return rdvRepo.findAll();
    }

    @Override
    public RDV updateRdv(Long id, RDV rdv) {
        if (!rdvRepo.existsById(Math.toIntExact(id))) {
            return null; // Or throw an exception if you prefer
        }
        rdv.setId(Math.toIntExact(id));
        return rdvRepo.save(rdv);
    }

    @Override
    public void deleteRdv(Long id) {
        if (rdvRepo.existsById(Math.toIntExact(id))) {
            rdvRepo.deleteById(Math.toIntExact(id));
        }
    }
}