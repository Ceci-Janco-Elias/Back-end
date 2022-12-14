
package com.portfolio.ceci.security.service;

import com.portfolio.ceci.security.entity.Rol;
import com.portfolio.ceci.security.enums.RolNombre;
import com.portfolio.ceci.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save (Rol rol){
        iRolRepository.save(rol);
    }
}
