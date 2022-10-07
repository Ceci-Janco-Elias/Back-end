package com.portfolio.ceci.service;

import com.portfolio.ceci.entity.HardSkills;
import com.portfolio.ceci.repository.IHardSkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardSkillsService {

    @Autowired
    IHardSkillsRepository iHardSkillsRepository;

    public List<HardSkills> list() {
        return iHardSkillsRepository.findAll();
    }

    public Optional<HardSkills> getOne(int id) {
        return iHardSkillsRepository.findById(id);
    }

    public Optional<HardSkills> getByNombreHS(String nombreHS) {
        return iHardSkillsRepository.findByNombreHS(nombreHS);
    }

    public void save(HardSkills hs) {
        iHardSkillsRepository.save(hs);
    }

    public void delete(int id) {
        iHardSkillsRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iHardSkillsRepository.existsById(id);
    }

    public boolean existsByNombreHS(String nombreHS) {
        return iHardSkillsRepository.existsByNombreHS(nombreHS);
    }
}
