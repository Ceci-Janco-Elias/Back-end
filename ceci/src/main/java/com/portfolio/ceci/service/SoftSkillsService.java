package com.portfolio.ceci.service;

import com.portfolio.ceci.entity.SoftSkills;
import com.portfolio.ceci.repository.ISoftSkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillsService {

    @Autowired
    ISoftSkillsRepository iSoftSkillsRepository;

    public List<SoftSkills> list() {
        return iSoftSkillsRepository.findAll();
    }

    public Optional<SoftSkills> getOne(int id) {
        return iSoftSkillsRepository.findById(id);
    }

    public Optional<SoftSkills> getByNombreSS(String nombreSS) {
        return iSoftSkillsRepository.findByNombreSS(nombreSS);
    }

    public void save(SoftSkills ss) {
        iSoftSkillsRepository.save(ss);
    }

    public void delete(int id) {
        iSoftSkillsRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iSoftSkillsRepository.existsById(id);
    }

    public boolean existsByNombreSS(String nombreSS) {
        return iSoftSkillsRepository.existsByNombreSS(nombreSS);
    }

}
