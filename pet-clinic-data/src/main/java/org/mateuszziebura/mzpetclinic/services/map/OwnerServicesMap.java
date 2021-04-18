package org.mateuszziebura.mzpetclinic.services.map;

import org.mateuszziebura.mzpetclinic.model.Owner;
import org.mateuszziebura.mzpetclinic.model.Pet;
import org.mateuszziebura.mzpetclinic.services.OwnerServices;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.mateuszziebura.mzpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class OwnerServicesMap extends AbstractMapService<Owner, Long> implements OwnerServices {

    private final PetTypeService petTypeService;
    private final PetServices petServices;

    public OwnerServicesMap(PetTypeService petTypeService, PetServices petServices) {
        this.petTypeService = petTypeService;
        this.petServices = petServices;
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Map.Entry<Long,Owner> owner: super.map.entrySet()){
            if(owner.getValue().getLastName().equals(lastName)){
                return super.map.get(owner.getKey());
            }
        }
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object!=null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw new RuntimeException("Pet type required");
                    }
                    if(pet.getId()==null){
                        Pet savedPet = petServices.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else {
            return null;
        }

    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
