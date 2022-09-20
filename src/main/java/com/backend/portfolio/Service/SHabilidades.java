/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Service;

import com.backend.portfolio.Entity.Habilidades;
import com.backend.portfolio.Repository.RHabilidades;
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
public class SHabilidades {
    @Autowired
    RHabilidades rHabilidades;
    
    public List<Habilidades> list () {
        return rHabilidades.findAll();
    }
    
    public Optional <Habilidades> getOne (int id) {
        return rHabilidades.findById(id);
    }
    
    public Optional <Habilidades> getByDescripcion(String descripcion){
        return rHabilidades.findByDescripcion(descripcion);
    }
    
    public void save(Habilidades habilidad){
        rHabilidades.save(habilidad);
    }
    
    public void delete (int id){
        rHabilidades.deleteById(id);
    }
    
    public boolean existsById (int id){
        return rHabilidades.existsById(id);
    }
    
    public boolean existsByDescripcion(String descripcion){
        return rHabilidades.existsByDescripcion(descripcion);
    }
}
