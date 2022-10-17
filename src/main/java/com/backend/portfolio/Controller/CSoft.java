/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Controller;

import com.backend.portfolio.Dto.dtoSoft;
import com.backend.portfolio.Entity.Soft;
import com.backend.portfolio.Security.Controller.Mensaje;
import com.backend.portfolio.Service.SSoft;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dalmiro Rivero
 */

@RestController
@RequestMapping("/shabilidades")
@CrossOrigin(origins = {"https://dalmirorivero.com.ar" , "https://frontendportfolio-e6cc4.web.app"})
public class CSoft {
    @Autowired
    SSoft sSoft;
    
    @GetMapping("/lista")
     public ResponseEntity <List<Soft>> list(){
        List<Soft> list = sSoft.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> delete (@PathVariable("id") int id){
        if(!sSoft.existsById(id)){
            return new ResponseEntity(new Mensaje("ID Inexistente."), HttpStatus.NOT_FOUND);
        }
        sSoft.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada."), HttpStatus.OK);
    }
   
   @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody dtoSoft dtosoft){
        if(StringUtils.isBlank(dtosoft.getSdescripcion())){
            return new ResponseEntity(new Mensaje("Porcentaje obligatorio."), HttpStatus.BAD_REQUEST);
        }
       if(sSoft.existsBySdescripcion(dtosoft.getSdescripcion())){
           return new ResponseEntity(new Mensaje("Porcentaje Utilizado"), HttpStatus.BAD_REQUEST);
       }
       
       
       Soft soft = new Soft (
               dtosoft.getSdescripcion(), dtosoft.getSporcentaje()
       );
       sSoft.save(soft);
       return new ResponseEntity(new Mensaje ("Habilidad creada con exito!"), HttpStatus.OK);
       
    } 
  
   @PutMapping("/update/{id}")
  public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoSoft dtosoft){
        if(!sSoft.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sSoft.existsBySdescripcion(dtosoft.getSdescripcion()) && sSoft.getBySdescripcion(dtosoft.getSdescripcion())
                .get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya utilizado"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtosoft.getSdescripcion())){
          return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
      }
    
    Soft soft = sSoft.getOne(id).get();
    soft.setSdescripcion(dtosoft.getSdescripcion());
    soft.setSporcentaje(dtosoft.getSporcentaje());
    
    
    sSoft.save(soft);
    
    return new ResponseEntity(new Mensaje("Campo actualizado con exito!"), HttpStatus.OK);
}
  
   @GetMapping("/detail/{id}")
    public ResponseEntity<Soft> getById(@PathVariable("id")int id){
        if(!sSoft.existsById(id)){
            return new ResponseEntity(new Mensaje("ID Inexistente"), HttpStatus.BAD_REQUEST);
        }
        
        Soft soft = sSoft.getOne(id).get();
        return new ResponseEntity(soft, HttpStatus.OK);
    }
    
}
