package org.mateuszziebura.mzpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pet")
public class Pet extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "types")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;

    @Column(name = "birth_day")
    private LocalDate birthDate;
}
