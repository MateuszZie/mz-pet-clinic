package org.mateuszziebura.mzpetclinic.services.map;

import org.mateuszziebura.mzpetclinic.model.Pet;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class PetServicesMap extends AbstractMapService<Pet, Long> implements PetServices {
    
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
