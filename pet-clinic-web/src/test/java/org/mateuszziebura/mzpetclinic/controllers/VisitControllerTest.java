package org.mateuszziebura.mzpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mateuszziebura.mzpetclinic.model.Pet;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.mateuszziebura.mzpetclinic.services.VisitServices;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    PetServices petServices;

    @Mock
    VisitServices visitServices;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;

    Pet pet;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
        pet = new Pet();
    }

    @Test
    void initNewVisitForm() throws Exception{
        when(petServices.findById(anyLong())).thenReturn(pet);
        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"))
                .andExpect(model().attributeExists("visit"))
                .andExpect(model().attributeExists("pet"));
    }

    @Test
    void processNewVisitForm() throws Exception{
        when(petServices.findById(anyLong())).thenReturn(pet);
        mockMvc.perform(post("/owners/1/pets/1/visits/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().attributeExists("visit"))
                .andExpect(model().attributeExists("pet"));

        verify(visitServices).save(any());
    }
}