/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Service;

import com.backend.portfolio.Entity.Perfil;
import com.backend.portfolio.Repository.RPerfil;
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
public class SPerfil {
    
    @Autowired
    RPerfil rPerfil;
    
    public List<Perfil> list () {
        return rPerfil.findAll();
    }
    
    public Optional <Perfil> getOne (int id){
        return rPerfil.findById(id);
    }
    
    public Optional <Perfil> getByPerfil (String perfil){
        return rPerfil.findByPerfil(perfil);
    }
    
    public void save (Perfil perfil){
        rPerfil.save(perfil);
    }
    
    public void delete (int id){
        rPerfil.existsById(id);
    }
    
    public boolean existsById(int id){
        return rPerfil.existsById(id);
    }
    
    public boolean existsByPerfil (String perfil){
        return rPerfil.existsByPerfil(perfil);
    }
}
