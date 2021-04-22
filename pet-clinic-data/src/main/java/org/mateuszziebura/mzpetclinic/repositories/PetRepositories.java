package org.mateuszziebura.mzpetclinic.repositories;

import org.mateuszziebura.mzpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepositories extends CrudRepository<Pet,Long> {
}
