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
public class dtoPersona {
    
    @NotBlank
    private String bio;

    public dtoPersona() {
    }

    public dtoPersona(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
    

  
    
    
}
