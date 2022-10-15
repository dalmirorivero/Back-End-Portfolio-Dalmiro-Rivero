/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Dto;


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
    private String img;

    public dtoPerfil() {
    }

    public dtoPerfil(String perfil, String descripcion, String img) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
