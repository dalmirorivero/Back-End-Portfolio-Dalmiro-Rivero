/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Dto;

import java.sql.Blob;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Dalmiro Rivero
 */
public class dtoPerfil {
    
    @NotBlank
    private String perfil;
    @NotBlank
    private String descripcion;
    @NotBlank
    private Blob img;

    public dtoPerfil() {
    }

    public dtoPerfil(String perfil, String descripcion, Blob img) {
        this.perfil = perfil;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }
    
    
}
