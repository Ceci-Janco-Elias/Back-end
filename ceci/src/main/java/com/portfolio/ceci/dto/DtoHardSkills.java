package com.portfolio.ceci.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoHardSkills {

    @NotBlank
    private String nombreHS;
    @NotBlank
    private String porcentajeHS;

    public DtoHardSkills() {
    }

    public DtoHardSkills(String nombreHS, String porcentajeHS) {
        this.nombreHS = nombreHS;
        this.porcentajeHS = porcentajeHS;
    }
}
