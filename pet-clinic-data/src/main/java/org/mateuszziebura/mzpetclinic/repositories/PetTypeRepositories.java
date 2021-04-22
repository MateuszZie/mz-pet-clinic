package org.mateuszziebura.mzpetclinic.repositories;

import org.mateuszziebura.mzpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepositories extends CrudRepository<PetType,Long> {
}
