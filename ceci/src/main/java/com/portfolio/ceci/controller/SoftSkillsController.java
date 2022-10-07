package com.portfolio.ceci.controller;

import com.portfolio.ceci.dto.DtoSoftSkills;
import com.portfolio.ceci.entity.SoftSkills;
import com.portfolio.ceci.security.controller.Mensaje;
import com.portfolio.ceci.service.SoftSkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/softskills")
@CrossOrigin(origins = "http://localhost:4200")
public class SoftSkillsController {

    @Autowired
    SoftSkillsService softSkillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<SoftSkills>> list() {
        List<SoftSkills> list = softSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkills> getById(@PathVariable("id") int id) {
        if (!softSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        }
        SoftSkills softSkills = softSkillsService.getOne(id).get();
        return new ResponseEntity(softSkills, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSoftSkills dtoSoftSkills) {
        if (StringUtils.isBlank(dtoSoftSkills.getNombreSS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (softSkillsService.existsByNombreSS(dtoSoftSkills.getNombreSS())) {
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        SoftSkills softSkills = new SoftSkills(dtoSoftSkills.getNombreSS(), dtoSoftSkills.getPorcentajeSS());
        softSkillsService.save(softSkills);

        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSoftSkills dtoSoftSkills) {
        if (!softSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (softSkillsService.existsByNombreSS(dtoSoftSkills.getNombreSS()) && softSkillsService.getByNombreSS(dtoSoftSkills.getNombreSS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoSoftSkills.getNombreSS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        SoftSkills softSkills = softSkillsService.getOne(id).get();
        softSkills.setNombreSS(dtoSoftSkills.getNombreSS());
        softSkills.setPorcentajeSS(dtoSoftSkills.getPorcentajeSS());

        softSkillsService.save(softSkills);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!softSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }

        softSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

}
