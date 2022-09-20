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
public class dtoHabilidades {
    @NotBlank
    private String descripcion;
    @NotBlank
    private int porcentaje;

    public dtoHabilidades() {
    }

    public dtoHabilidades(String descripcion, int porcentaje) {
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setProcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
