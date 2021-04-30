package org.mateuszziebura.mzpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mateuszziebura.mzpetclinic.model.Owner;
import org.mateuszziebura.mzpetclinic.repositories.OwnerRepositories;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSPJpaServiceTest {

    @Mock
    OwnerRepositories ownerRepositories;

    @InjectMocks
    OwnerSPJpaService ownerSPJpaService;

    String surname = "Smith";
    Long id = 1L;
    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(id).lastName(surname).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepositories.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = ownerSPJpaService.findByLastName(surname);

        assertNotNull(owner);
        assertEquals(surname,owner.getLastName());
        verify(ownerRepositories).findByLastName(any());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepositories.findById(any())).thenReturn(java.util.Optional.empty());
        Owner owner = ownerSPJpaService.findById(id);

        assertNull(owner);
        verify(ownerRepositories).findById(any());
    }
    @Test
    void findById() {
        when(ownerRepositories.findById(any())).thenReturn(java.util.Optional.ofNullable(returnOwner));
        Owner owner = ownerSPJpaService.findById(id);

        assertNotNull(owner);
        assertEquals(id,owner.getId());
        verify(ownerRepositories).findById(any());
    }

    @Test
    void save() {
        when(ownerRepositories.save(any())).thenReturn(returnOwner);
        Owner owner = ownerSPJpaService.save(returnOwner);
        assertNotNull(owner);
        verify(ownerRepositories).save(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(returnOwner);
        when(ownerRepositories.findAll()).thenReturn(owners);
        Set<Owner> owners1 = ownerSPJpaService.findAll();

        assertNotNull(owners1);
        verify(ownerRepositories).findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void delete() {
        ownerSPJpaService.delete(returnOwner);

        verify(ownerRepositories).delete(any());
    }

    @Test
    void deleteById() {
        ownerSPJpaService.deleteById(id);

        verify(ownerRepositories).deleteById(any());
    }
}