package org.mateuszziebura.mzpetclinic.repositories;

import org.mateuszziebura.mzpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepositories extends CrudRepository<Owner,Long> {
}
