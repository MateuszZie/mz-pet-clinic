package org.mateuszziebura.mzpetclinic.services;

import org.mateuszziebura.mzpetclinic.model.Vet;

import java.util.Set;

public interface VetServices {
    Vet findById (Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
