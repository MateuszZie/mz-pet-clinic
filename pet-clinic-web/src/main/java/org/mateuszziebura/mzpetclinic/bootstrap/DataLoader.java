package org.mateuszziebura.mzpetclinic.bootstrap;

import org.mateuszziebura.mzpetclinic.model.*;
import org.mateuszziebura.mzpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerServices;
    private final VetServices vetServices;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitServices visitServices;

    public DataLoader(OwnerService ownerServices, VetServices vetServices, PetTypeService petTypeService, SpecialityService specialityService, VisitServices visitServices) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitServices = visitServices;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size()==0){
            LoadData();
        }
    }

    private void LoadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Chabrowa 12");
        owner1.setCity("Rybnik");
        owner1.setTelephone("213123123");


        Pet mikePet = new Pet();
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Roco");
        mikePet.setOwner(owner1);
        mikePet.setPetType(saveDogPetType);
        owner1.getPets().add(mikePet);


        ownerServices.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Chabrowa 12");
        owner2.setCity("Rybnik");
        owner2.setTelephone("213123123");

        Pet fionaCat = new Pet();
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("just cat");
        fionaCat.setOwner(owner2);
        fionaCat.setPetType(saveCatPetType);
        owner2.getPets().add(fionaCat);


        ownerServices.save(owner2);

        Visit fionaVisit = new Visit();
        fionaVisit.setDate(LocalDate.now());
        fionaVisit.setDescription("sneeze Cat");
        fionaVisit.setPet(fionaCat);

        visitServices.save(fionaVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedDentistry);

        vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedRadiology);

        vetServices.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
