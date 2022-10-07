
package com.portfolio.ceci.controller;

import com.portfolio.ceci.dto.DtoHardSkills;
import com.portfolio.ceci.entity.HardSkills;
import com.portfolio.ceci.security.controller.Mensaje;
import com.portfolio.ceci.service.HardSkillsService;
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
@RequestMapping("/hardskills")
@CrossOrigin(origins = "http://localhost:4200")
public class HardSkillsController {
    @Autowired
    HardSkillsService hardSkillsService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HardSkills>> list() {
        List<HardSkills> list = hardSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkills> getById(@PathVariable("id") int id) {
        if (!hardSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        }
        HardSkills hardSkills = hardSkillsService.getOne(id).get();
        return new ResponseEntity(hardSkills, HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHardSkills dtoHardSkills) {
        if (StringUtils.isBlank(dtoHardSkills.getNombreHS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (hardSkillsService.existsByNombreHS(dtoHardSkills.getNombreHS())) {
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        HardSkills hardSkills = new HardSkills(dtoHardSkills.getNombreHS(), dtoHardSkills.getPorcentajeHS());
        hardSkillsService.save(hardSkills);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);        
    }    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHardSkills dtoHardSkills) {
        if (!hardSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (hardSkillsService.existsByNombreHS(dtoHardSkills.getNombreHS()) && hardSkillsService.getByNombreHS(dtoHardSkills.getNombreHS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoHardSkills.getNombreHS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        HardSkills hardSkills = hardSkillsService.getOne(id).get();
        hardSkills.setNombreHS(dtoHardSkills.getNombreHS());
        hardSkills.setPorcentajeHS(dtoHardSkills.getPorcentajeHS());
        
        hardSkillsService.save(hardSkills);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hardSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        hardSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);        
    } 
}
