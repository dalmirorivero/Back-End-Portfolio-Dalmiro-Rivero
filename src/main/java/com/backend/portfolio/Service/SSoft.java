/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Service;

import com.backend.portfolio.Entity.Soft;
import com.backend.portfolio.Repository.RSoft;
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
public class SSoft {
    @Autowired
    RSoft rSoft;
    
    public List <Soft> list (){
        return rSoft.findAll();
    }
    
    public Optional <Soft> getOne(int id){
        return rSoft.findById(id);
    }
    
    public Optional <Soft> getBySdescripcion(String sdescripcion){
        return rSoft.findBySdescripcion(sdescripcion);
    }
    
    public void save(Soft soft){
        rSoft.save(soft);
    }
    
    public void delete (int id){
        rSoft.deleteById(id);
    }
    
    public boolean existsById (int id){
        return rSoft.existsById(id);
    }
    
    public boolean existsBySdescripcion (String sdescripcion){
        return rSoft.existsBySdescripcion(sdescripcion);
    }
}
