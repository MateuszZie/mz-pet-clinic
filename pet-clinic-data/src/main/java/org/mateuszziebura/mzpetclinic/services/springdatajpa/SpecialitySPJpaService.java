package org.mateuszziebura.mzpetclinic.services.springdatajpa;

import org.mateuszziebura.mzpetclinic.model.Speciality;
import org.mateuszziebura.mzpetclinic.repositories.SpecialityRepositories;
import org.mateuszziebura.mzpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class SpecialitySPJpaService implements SpecialityService {

    private final SpecialityRepositories specialityRepositories;

    public SpecialitySPJpaService(SpecialityRepositories specialityRepositories) {
        this.specialityRepositories = specialityRepositories;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepositories.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitys = new HashSet<>();
        specialityRepositories.findAll().forEach(specialitys::add);
        return specialitys;
    }

    @Override
    public void delete(Speciality object) {
        specialityRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepositories.deleteById(aLong);
    }
}
