package org.mateuszziebura.mzpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vet")
public class Vet extends Person{

    @ManyToMany
    @JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality"))
    private Set<Speciality> specialities = new HashSet<>();
}
