package org.mateuszziebura.mzpetclinic.controllers;

import org.mateuszziebura.mzpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerServices;

    public OwnerController(OwnerService ownerServices) {
        this.ownerServices = ownerServices;
    }

    @RequestMapping({"/","","/index","/index.html"})
    public String ownerList(Model model){
        model.addAttribute("owners",ownerServices.findAll());
        return "owners/index";
    }
    @RequestMapping("/find")
    public String find(){
        return "notready";
    }
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerServices.findById(ownerId));
        return mav;
    }
}
