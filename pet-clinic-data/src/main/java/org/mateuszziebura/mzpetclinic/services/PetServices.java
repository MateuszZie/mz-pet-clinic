package org.mateuszziebura.mzpetclinic.services;


import org.mateuszziebura.mzpetclinic.model.Pet;

import java.util.Set;

public interface PetServices {
    Pet findById (Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
