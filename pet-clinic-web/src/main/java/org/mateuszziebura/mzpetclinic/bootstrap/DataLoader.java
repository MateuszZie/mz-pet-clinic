package org.mateuszziebura.mzpetclinic.bootstrap;

import org.mateuszziebura.mzpetclinic.model.Owner;
import org.mateuszziebura.mzpetclinic.model.Pet;
import org.mateuszziebura.mzpetclinic.model.PetType;
import org.mateuszziebura.mzpetclinic.model.Vet;
import org.mateuszziebura.mzpetclinic.services.OwnerServices;
import org.mateuszziebura.mzpetclinic.services.PetTypeService;
import org.mateuszziebura.mzpetclinic.services.VetServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetServices vetServices;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerServices ownerServices, VetServices vetServices, PetTypeService petTypeService) {
        this.ownerServices = ownerServices;
        this.vetServices = vetServices;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

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
        owner1.setAddress("Chabrowa 12");
        owner1.setCity("Rybnik");
        owner1.setTelephone("213123123");

        Pet fionaCat = new Pet();
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("just cat");
        fionaCat.setOwner(owner2);
        fionaCat.setPetType(saveCatPetType);
        owner2.getPets().add(fionaCat);

        ownerServices.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetServices.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
