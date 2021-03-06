package org.mateuszziebura.mzpetclinic.services.springdatajpa;

import org.mateuszziebura.mzpetclinic.model.Vet;
import org.mateuszziebura.mzpetclinic.repositories.VetRepositories;
import org.mateuszziebura.mzpetclinic.services.VetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class VetSPJpaService implements VetServices {

    private final VetRepositories vetRepositories;

    public VetSPJpaService(VetRepositories vetRepositories) {
        this.vetRepositories = vetRepositories;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepositories.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepositories.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void delete(Vet object) {
        vetRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepositories.deleteById(aLong);
    }
}
