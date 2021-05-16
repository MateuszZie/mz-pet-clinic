package org.mateuszziebura.mzpetclinic.services.springdatajpa;

import org.mateuszziebura.mzpetclinic.model.Owner;
import org.mateuszziebura.mzpetclinic.repositories.OwnerRepositories;
import org.mateuszziebura.mzpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class OwnerSPJpaService implements OwnerService {

    private final OwnerRepositories ownerRepositories;

    public OwnerSPJpaService(OwnerRepositories ownerRepositories) {
        this.ownerRepositories = ownerRepositories;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepositories.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepositories.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepositories.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepositories.deleteById(aLong);
    }
}
