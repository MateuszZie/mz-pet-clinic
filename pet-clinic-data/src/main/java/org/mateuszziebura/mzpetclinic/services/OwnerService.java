package org.mateuszziebura.mzpetclinic.services;

import org.mateuszziebura.mzpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
