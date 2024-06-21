package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.RDV;

import java.util.List;

public interface IRDVService {
    RDV AddRdv(RDV rdv);

    List<RDV> getRdvById(Long id);

    RDV updateRdv(Long id, RDV rdv);

    void deleteRdv(Long id);
}