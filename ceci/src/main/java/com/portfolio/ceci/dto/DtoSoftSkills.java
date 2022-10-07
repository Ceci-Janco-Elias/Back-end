package com.portfolio.ceci.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSoftSkills {

    @NotBlank
    private String nombreSS;
    @NotBlank
    private String porcentajeSS;

    public DtoSoftSkills() {
    }

    public DtoSoftSkills(String nombreSS, String porcentajeSS) {
        this.nombreSS = nombreSS;
        this.porcentajeSS = porcentajeSS;
    }

}
