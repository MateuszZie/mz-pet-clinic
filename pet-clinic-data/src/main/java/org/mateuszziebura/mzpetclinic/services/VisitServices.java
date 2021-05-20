package org.mateuszziebura.mzpetclinic.services;

import org.mateuszziebura.mzpetclinic.model.Visit;

import java.util.Set;

public interface VisitServices extends CrudService<Visit, Long>{
    Set<Visit> findByPetId(Long petId);
}
