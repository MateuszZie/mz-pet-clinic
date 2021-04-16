package org.mateuszziebura.mzpetclinic.controllers;

import org.mateuszziebura.mzpetclinic.services.OwnerServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerServices ownerServices;

    public OwnerController(OwnerServices ownerServices) {
        this.ownerServices = ownerServices;
    }

    @RequestMapping({"/","","/index","/index.html"})
    public String ownerList(Model model){
        model.addAttribute("owners",ownerServices.findAll());
        return "owners/index";
    }
}
