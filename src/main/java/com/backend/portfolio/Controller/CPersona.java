/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Controller;

import com.backend.portfolio.Dto.dtoPersona;
import com.backend.portfolio.Entity.Persona;
import com.backend.portfolio.Security.Controller.Mensaje;
import com.backend.portfolio.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dalmiro Rivero
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"https://dalmirorivero.com.ar" , "https://frontendportfolio-e6cc4.web.app", "http://localhost:4200"})
public class CPersona {
    
    @Autowired
    SPersona sPersona;
    
    @GetMapping("/lista")
     public ResponseEntity<List<Persona>> list(){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
      if(!sPersona.existsById(id)){
          return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
      } 
      if(sPersona.existsByBio(dtopersona.getBio()) && sPersona.getByBio(dtopersona.getBio()).get().getId() != id){
          return new ResponseEntity(new Mensaje("Nombre ya utilizado"), HttpStatus.BAD_REQUEST);
      }
      if(StringUtils.isBlank(dtopersona.getBio())){
          return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
      }
      
      Persona persona = sPersona.getOne(id).get();
      
      persona.setBio(dtopersona.getBio());
      
      
      sPersona.save(persona);
      
      return new ResponseEntity(new Mensaje("Campo actualizado con exito!"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("ID Inexistente"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
