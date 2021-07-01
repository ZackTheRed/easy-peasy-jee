package com.emsi.srhiri.examjee.demo.repositories;

import com.emsi.srhiri.examjee.demo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
