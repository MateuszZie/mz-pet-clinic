package org.mateuszziebura.mzpetclinic.services.map;

import org.mateuszziebura.mzpetclinic.model.Vet;
import org.mateuszziebura.mzpetclinic.services.VetServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServicesMap extends AbstractMapService<Vet, Long> implements VetServices {
    
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
