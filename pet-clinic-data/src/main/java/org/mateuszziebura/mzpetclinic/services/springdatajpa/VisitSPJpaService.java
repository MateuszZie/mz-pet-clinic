package org.mateuszziebura.mzpetclinic.services.springdatajpa;

import org.mateuszziebura.mzpetclinic.model.Visit;
import org.mateuszziebura.mzpetclinic.repositories.PetRepositories;
import org.mateuszziebura.mzpetclinic.repositories.VisitRepositories;
import org.mateuszziebura.mzpetclinic.services.VisitServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class VisitSPJpaService implements VisitServices {

    private final VisitRepositories visitRepositories;
    private final PetRepositories petRepositories;

    public VisitSPJpaService(VisitRepositories visitRepositories, PetRepositories petRepositories) {
        this.visitRepositories = visitRepositories;
        this.petRepositories = petRepositories;
    }

    @Override
    public Set<Visit> findByPetId(Long petId) {
        return petRepositories.findById(petId).orElse(null).getVisits();
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepositories.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepositories.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void delete(Visit object) {
        visitRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepositories.deleteById(aLong);
    }
}
