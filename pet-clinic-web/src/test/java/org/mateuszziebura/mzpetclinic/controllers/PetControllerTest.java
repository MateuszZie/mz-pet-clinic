package org.mateuszziebura.mzpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mateuszziebura.mzpetclinic.model.Owner;
import org.mateuszziebura.mzpetclinic.model.Pet;
import org.mateuszziebura.mzpetclinic.model.PetType;
import org.mateuszziebura.mzpetclinic.services.OwnerService;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.mateuszziebura.mzpetclinic.services.PetTypeService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetServices petServices;
    @Mock
    OwnerService ownerService;
    @Mock
    PetTypeService typeService;
    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;

    Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1l).build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1L).name("Dog").build());
        petTypes.add(PetType.builder().id(2L).name("Cat").build());
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void initCreationForm() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("owner"));
    }
    @Test
    void processCreationForm() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("owner"));

        verify(petServices).save(any());
    }
    @Test
    void initUpdatePetForm() throws Exception{
        when(petServices.findById(anyLong())).thenReturn(Pet.builder().id(1L).build());
        mockMvc.perform(get("/owners/1/pets/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("pet"));

        verify(petServices).findById(anyLong());

    }
    @Test
    void processUpdatePetForm() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(post("/owners/1/pets/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("pet"));

        verify(petServices).save(any());
    }
}