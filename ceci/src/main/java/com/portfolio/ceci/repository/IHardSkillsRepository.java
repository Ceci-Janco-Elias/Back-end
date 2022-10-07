
package com.portfolio.ceci.repository;

import com.portfolio.ceci.entity.HardSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHardSkillsRepository extends JpaRepository<HardSkills, Integer>{
    public Optional<HardSkills> findByNombreHS(String nombreHS);

    public boolean existsByNombreHS(String nombreHS);
}
