package com.portfolio.ceci.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HardSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHS;
    private String porcentajeHS;

    public HardSkills() {
    }

    public HardSkills(String nombreHS, String porcentajeHS) {
        this.nombreHS = nombreHS;
        this.porcentajeHS = porcentajeHS;
    }
}