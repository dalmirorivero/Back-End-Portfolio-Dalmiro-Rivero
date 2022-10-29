/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Service;

import com.backend.portfolio.Entity.Persona;
import com.backend.portfolio.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dalmiro Rivero
 */
@Service
@Transactional
public class SPersona {
    
    @Autowired
    RPersona rPersona;
    
    public List<Persona> list () {
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne (int id){
        return rPersona.findById(id);
    }
    
    public Optional <Persona> getByBio (String bio) {
        return rPersona.findByBio(bio);
    }
    
    public void save (Persona persona) {
        rPersona.save(persona);
    }
    
    public void delete (int id){
        rPersona.existsById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByBio (String bio){
        return rPersona.existsByBio(bio);
    }
}
