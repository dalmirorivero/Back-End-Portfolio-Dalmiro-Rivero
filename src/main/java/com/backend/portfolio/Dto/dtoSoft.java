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
public class dtoSoft {
    @NotBlank
    private String sdescripcion;
    @NotBlank
    private int sporcentaje;

    public dtoSoft() {
    }

    public dtoSoft(String sdescripcion, int sporcentaje) {
        this.sdescripcion = sdescripcion;
        this.sporcentaje = sporcentaje;
    }

    public String getSdescripcion() {
        return sdescripcion;
    }

    public void setSdescripcion(String sdescripcion) {
        this.sdescripcion = sdescripcion;
    }

    public int getSporcentaje() {
        return sporcentaje;
    }

    public void setSporcentaje(int sporcentaje) {
        this.sporcentaje = sporcentaje;
    }
    
    
}
