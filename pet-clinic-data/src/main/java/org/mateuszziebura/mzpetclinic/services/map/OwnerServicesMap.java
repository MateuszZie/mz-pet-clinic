package org.mateuszziebura.mzpetclinic.services.map;

import org.mateuszziebura.mzpetclinic.model.Owner;
import org.mateuszziebura.mzpetclinic.services.OwnerServices;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class OwnerServicesMap extends AbstractMapService<Owner, Long> implements OwnerServices {

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
        return super.save(object.getId(), object);
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
