/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.portfolio.Repository;

import com.backend.portfolio.Entity.Soft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dalmiro Rivero
 */
@Repository
public interface RSoft extends JpaRepository<Soft, Integer> {
    public Optional <Soft> findBySdescripcion(String sdescripcion);
    public boolean existsBySdescripcion (String sdescripcion);
    
    
}
