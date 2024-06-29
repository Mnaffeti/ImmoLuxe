package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.RDV;
import com.example.immoluxe.Repository.RDVRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RDVServiceImp implements IRDVService {
    private final RDVRepository rdvRepo;

    @Override
    public RDV AddRdv(RDV rdv) {
        return rdvRepo.save(rdv);
    }

    @Override
    public List<RDV> findAll() {
        return rdvRepo.findAll();
    }

    @Override
    public RDV findById(int id) {
        return rdvRepo.findById(id).orElse(null);
    }

    @Override
    public RDV updateRdv(int id, RDV rdv) {
        RDV existingRdv = rdvRepo.findById(id).orElse(null);
        if (existingRdv != null) {
            rdv.setId(id);
            return rdvRepo.save(rdv);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        rdvRepo.deleteById(id);
    }
}
