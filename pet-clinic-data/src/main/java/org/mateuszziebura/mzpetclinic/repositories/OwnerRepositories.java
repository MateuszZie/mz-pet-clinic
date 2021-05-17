package org.mateuszziebura.mzpetclinic.repositories;

import org.mateuszziebura.mzpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepositories extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
