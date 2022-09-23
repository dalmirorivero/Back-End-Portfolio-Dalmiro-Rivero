/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dalmiro Rivero
 */
@Entity
public class Soft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String sdescripcion;
    private int sporcentaje;

    public Soft() {
    }

    public Soft(String sdescripcion, int sporcentaje) {
        this.sdescripcion = sdescripcion;
        this.sporcentaje = sporcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
