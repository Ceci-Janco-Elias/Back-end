package com.portfolio.ceci.repository;

import com.portfolio.ceci.entity.SoftSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftSkillsRepository extends JpaRepository<SoftSkills, Integer> {

    public Optional<SoftSkills> findByNombreSS(String nombreSS);

    public boolean existsByNombreSS(String nombreSS);
}
