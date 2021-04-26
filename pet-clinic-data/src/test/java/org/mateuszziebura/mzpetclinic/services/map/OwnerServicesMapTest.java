package org.mateuszziebura.mzpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mateuszziebura.mzpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServicesMapTest {

    OwnerServicesMap ownerServicesMap;

    Long idValue = 1L;

    String surname = "smith";
    @BeforeEach
    void setUp() {
        ownerServicesMap= new OwnerServicesMap(new PetTypeServiceMap(), new PetServicesMap());

        ownerServicesMap.save(Owner.builder().id(idValue).lastName(surname).build());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServicesMap.findByLastName(surname);
        assertNotNull(owner);
    }
    @Test
    void findByLastNameNull(){
        Owner owner = ownerServicesMap.findByLastName("fuu");
        assertNull(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerServicesMap.findById(idValue);
        assertNotNull(owner);
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner saveOwner = ownerServicesMap.save(owner);
        assertNotNull(saveOwner);
        assertEquals(id,saveOwner.getId());

    }
    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();
        Owner saveOwner = ownerServicesMap.save(owner);
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());

    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServicesMap.findAll();

        assertEquals(1,owners.size());
    }

    @Test
    void delete() {
        ownerServicesMap.delete(ownerServicesMap.findById(idValue));
        assertEquals(0,ownerServicesMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServicesMap.deleteById(idValue);
        assertEquals(0,ownerServicesMap.findAll().size());
    }
}