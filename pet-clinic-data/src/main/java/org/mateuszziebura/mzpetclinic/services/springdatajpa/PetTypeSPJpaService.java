package org.mateuszziebura.mzpetclinic.services.springdatajpa;

import org.mateuszziebura.mzpetclinic.model.PetType;
import org.mateuszziebura.mzpetclinic.repositories.PetTypeRepositories;
import org.mateuszziebura.mzpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class PetTypeSPJpaService implements PetTypeService {

    private final PetTypeRepositories petTypeRepositories;

    public PetTypeSPJpaService(PetTypeRepositories petTypeRepositories) {
        this.petTypeRepositories = petTypeRepositories;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepositories.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepositories.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepositories.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public void delete(PetType object) {
        petTypeRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepositories.deleteById(aLong);
    }
}
