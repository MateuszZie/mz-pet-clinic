package org.mateuszziebura.mzpetclinic.services.springdatajpa;

import org.mateuszziebura.mzpetclinic.model.Pet;
import org.mateuszziebura.mzpetclinic.repositories.PetRepositories;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class PetSPJpaService implements PetServices {

    private final PetRepositories petRepositories;

    public PetSPJpaService(PetRepositories petRepositories) {
        this.petRepositories = petRepositories;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepositories.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepositories.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public void delete(Pet object) {
        petRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepositories.deleteById(aLong);
    }
}
