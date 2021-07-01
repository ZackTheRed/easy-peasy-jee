package com.emsi.srhiri.examjee.demo.repositories;

import com.emsi.srhiri.examjee.demo.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CoursRepository extends JpaRepository<Cours, Long> {
    public List<Cours> findByCodeEnseignant(Long id);
}
