package org.mateuszziebura.mzpetclinic.repositories;

import org.mateuszziebura.mzpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepositories extends CrudRepository<Visit,Long> {
}
