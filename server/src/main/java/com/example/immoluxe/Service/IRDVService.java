package com.example.immoluxe.Service;

import com.example.immoluxe.Entity.RDV;

import java.util.List;

public interface IRDVService {
    RDV AddRdv(RDV rdv);
    List<RDV> findAll();
    RDV findById(int id);
    RDV updateRdv(int id, RDV rdv);
    void deleteById(int id);
}
