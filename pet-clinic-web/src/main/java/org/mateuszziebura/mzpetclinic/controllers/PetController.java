package org.mateuszziebura.mzpetclinic.controllers;


import org.mateuszziebura.mzpetclinic.model.Owner;
import org.mateuszziebura.mzpetclinic.model.PetType;
import org.mateuszziebura.mzpetclinic.services.OwnerService;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.mateuszziebura.mzpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetServices pets;

    private final OwnerService owners;

    private final PetTypeService typeService;

    public PetController(PetServices pets, OwnerService owners, PetTypeService typeService) {
        this.pets = pets;
        this.owners = owners;
        this.typeService = typeService;
    }
    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return typeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return owners.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
