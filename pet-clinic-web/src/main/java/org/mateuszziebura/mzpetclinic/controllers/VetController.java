package org.mateuszziebura.mzpetclinic.controllers;

import org.mateuszziebura.mzpetclinic.services.VetServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetServices vetServices;

    public VetController(VetServices vetServices) {
        this.vetServices = vetServices;
    }

    @RequestMapping({"/vets","/vets/index","/vest/index.html"})
    public String vetList(Model model){
        model.addAttribute("vets", vetServices.findAll());
        return "vets/index";
    }
}
