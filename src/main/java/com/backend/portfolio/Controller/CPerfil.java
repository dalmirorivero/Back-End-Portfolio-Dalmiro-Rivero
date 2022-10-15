/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Controller;

import com.backend.portfolio.Dto.dtoPerfil;
import com.backend.portfolio.Entity.Perfil;
import com.backend.portfolio.Security.Controller.Mensaje;
import com.backend.portfolio.Service.SPerfil;
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
@RequestMapping("/perfil")
@CrossOrigin(origins = "https://frontendportfolio-e6cc4.web.app")
public class CPerfil {
    
     @Autowired
     SPerfil sPerfil;
     
     @GetMapping("/lista")
     public ResponseEntity<List<Perfil>> list(){
        List<Perfil> list = sPerfil.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoPerfil dtoperfil){
      if(!sPerfil.existsById(id)){
          return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
      } 
      if(sPerfil.existsByPerfil(dtoperfil.getPerfil()) && sPerfil.getByPerfil(dtoperfil.getPerfil()).get().getId() != id){
          return new ResponseEntity(new Mensaje("Nombre ya utilizado"), HttpStatus.BAD_REQUEST);
      }
      if(StringUtils.isBlank(dtoperfil.getPerfil())){
          return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
      }
      
      Perfil perfil = sPerfil.getOne(id).get();
      
      perfil.setPerfil(dtoperfil.getPerfil());
      perfil.setDescripcion(dtoperfil.getDescripcion());
      perfil.setImg (dtoperfil.getImg());
      
      sPerfil.save(perfil);
      
      return new ResponseEntity(new Mensaje("Campo actualizado con exito!"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable("id")int id){
        if(!sPerfil.existsById(id)){
            return new ResponseEntity(new Mensaje("ID Inexistente"), HttpStatus.BAD_REQUEST);
        }
        
        Perfil perfil = sPerfil.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }
}
