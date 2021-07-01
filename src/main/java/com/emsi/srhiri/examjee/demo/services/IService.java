package com.emsi.srhiri.examjee.demo.services;

import com.emsi.srhiri.examjee.demo.entities.Cours;
import com.emsi.srhiri.examjee.demo.entities.Enseignant;

import java.util.List;
import java.util.Optional;

public interface IService {
    void addCours(Cours cours);
    Enseignant findEnseignantById(Long Id);
    List<Cours> findCoursById(Enseignant enseignant);
}
