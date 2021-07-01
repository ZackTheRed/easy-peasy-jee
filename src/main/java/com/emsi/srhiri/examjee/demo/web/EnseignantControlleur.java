package com.emsi.srhiri.examjee.demo.web;

import com.emsi.srhiri.examjee.demo.entities.Cours;
import com.emsi.srhiri.examjee.demo.entities.Enseignant;
import com.emsi.srhiri.examjee.demo.repositories.CoursRepository;
import com.emsi.srhiri.examjee.demo.repositories.EnseignantRepository;
import com.emsi.srhiri.examjee.demo.services.IServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class EnseignantControlleur {
    @Autowired
    IServiceImpl IServiceImpl;

    @GetMapping(path = "/enseignant")
    public String enseignant(Model model,
                             @RequestParam(name = "id") Long id) {
        Enseignant enseignant;
        enseignant = IServiceImpl.findEnseignantById(id);

        model.addAttribute("enseignant", enseignant);
        model.addAttribute("cours", IServiceImpl.findCoursById(enseignant));
        return "enseignant";
    }
}
