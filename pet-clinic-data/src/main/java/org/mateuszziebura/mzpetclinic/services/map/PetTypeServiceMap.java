package org.mateuszziebura.mzpetclinic.services.map;

import org.mateuszziebura.mzpetclinic.model.PetType;
import org.mateuszziebura.mzpetclinic.services.PetTypeService;

import java.util.Set;

public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
