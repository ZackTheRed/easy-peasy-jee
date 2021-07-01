package com.emsi.srhiri.examjee.demo.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("Permanent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Permanent extends Enseignant {
    @NotNull
    private Long numSom;
}
