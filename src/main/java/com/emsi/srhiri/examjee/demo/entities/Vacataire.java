package com.emsi.srhiri.examjee.demo.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vacataire")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Vacataire extends Enseignant{
    @NotNull
    private Long tauxHoraire;
}
