/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.Controller;

import com.backend.portfolio.Dto.dtoHabilidades;
import com.backend.portfolio.Entity.Habilidades;
import com.backend.portfolio.Security.Controller.Mensaje;
import com.backend.portfolio.Service.SHabilidades;
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
@RequestMapping("/habilidades")
@CrossOrigin(origins = {"https://dalmirorivero.com.ar" , "https://frontendportfolio-e6cc4.web.app", "http://localhost:4200"})
public class CHabilidades {
    @Autowired
    SHabilidades sHabilidades;
    
    @GetMapping("/lista")
    public ResponseEntity <List<Habilidades>> list(){
        List<Habilidades> list = sHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id){
        if(!sHabilidades.existsById(id)){
            return new ResponseEntity(new Mensaje("ID Inexistente."), HttpStatus.NOT_FOUND);
        }
        sHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada."), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtohabilidades){
        if(StringUtils.isBlank(dtohabilidades.getDescripcion())){
            return new ResponseEntity(new Mensaje("Porcentaje obligatorio."), HttpStatus.BAD_REQUEST);
        }
       if(sHabilidades.existsByDescripcion(dtohabilidades.getDescripcion())){
           return new ResponseEntity(new Mensaje("Porcentaje Utilizado"), HttpStatus.BAD_REQUEST);
       }
       
       
       Habilidades habilidades = new Habilidades (
               dtohabilidades.getDescripcion(), dtohabilidades.getPorcentaje()
       );
       sHabilidades.save(habilidades);
       return new ResponseEntity(new Mensaje ("Habilidad creada con exito!"), HttpStatus.OK);
       
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoHabilidades dtohabilidades){
        if(!sHabilidades.existsById(id)){
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sHabilidades.existsByDescripcion(dtohabilidades.getDescripcion()) && sHabilidades.getByDescripcion(dtohabilidades.getDescripcion())
                .get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya utilizado"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohabilidades.getDescripcion())){
          return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
      }
    
    Habilidades habilidades = sHabilidades.getOne(id).get();
    habilidades.setDescripcion(dtohabilidades.getDescripcion());
    habilidades.setPorcentaje(dtohabilidades.getPorcentaje());
    
    
    sHabilidades.save(habilidades);
    
    return new ResponseEntity(new Mensaje("Campo actualizado con exito!"), HttpStatus.OK);
}
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id")int id){
        if(!sHabilidades.existsById(id)){
            return new ResponseEntity(new Mensaje("ID Inexistente"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidades habilidades = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
    
    
    
}
