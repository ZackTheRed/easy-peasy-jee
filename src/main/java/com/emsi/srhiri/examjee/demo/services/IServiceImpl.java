package com.emsi.srhiri.examjee.demo.services;

import com.emsi.srhiri.examjee.demo.entities.Cours;
import com.emsi.srhiri.examjee.demo.entities.Enseignant;
import com.emsi.srhiri.examjee.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IServiceImpl implements IService {
    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public void addCours(Cours cours) {
        coursRepository.save(cours);
    }

    @Override
    public Enseignant findEnseignantById(Long Id) {
        Enseignant e;
        e = enseignantRepository.findById(Id).orElse(new Enseignant());
        return e;
    }

    @Override
    public List<Cours> findCoursById(Enseignant enseignant) {
        List<Cours> listC;
        listC = coursRepository.findByCodeEnseignant(enseignant.getCode());
        return listC;
    }
}
