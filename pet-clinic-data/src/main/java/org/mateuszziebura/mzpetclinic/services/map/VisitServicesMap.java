package org.mateuszziebura.mzpetclinic.services.map;

import org.mateuszziebura.mzpetclinic.model.Visit;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.mateuszziebura.mzpetclinic.services.VisitServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitServicesMap extends AbstractMapService<Visit, Long> implements VisitServices {

    private final PetServices petServices;

    public VisitServicesMap(PetServices petServices) {
        this.petServices = petServices;
    }

    @Override
    public Set<Visit> findByPetId(Long petId) {
        return petServices.findById(petId).getVisits();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null  || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null || object.getPet().getOwner() == null
                ){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
