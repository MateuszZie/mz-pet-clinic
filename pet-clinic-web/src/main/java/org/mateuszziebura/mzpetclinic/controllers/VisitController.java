package org.mateuszziebura.mzpetclinic.controllers;

import org.mateuszziebura.mzpetclinic.model.Pet;
import org.mateuszziebura.mzpetclinic.model.Visit;
import org.mateuszziebura.mzpetclinic.services.PetServices;
import org.mateuszziebura.mzpetclinic.services.VisitServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
class VisitController {

    private final PetServices petServices;

    private final VisitServices visitServices;

    public VisitController(PetServices petServices, VisitServices visitServices) {
        this.petServices = petServices;
        this.visitServices = visitServices;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
     * we always have fresh data - Since we do not use the session scope, make sure that
     * Pet object always has an id (Even though id is not part of the form fields)
     * @param petId
     * @return Pet
     */
    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model) {
        Pet pet = petServices.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        visit.setPet(pet);
        pet.getVisits().add(visit);
        return visit;
    }

    // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm() {
        return "pets/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit,@PathVariable Long petId, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        }
        else {
            visitServices.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }

}
