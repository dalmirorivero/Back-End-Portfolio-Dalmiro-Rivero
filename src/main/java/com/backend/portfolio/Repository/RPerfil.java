/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.portfolio.Repository;

import com.backend.portfolio.Entity.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dalmiro Rivero
 */
@Repository
public interface RPerfil extends JpaRepository<Perfil, Integer> {
    public Optional <Perfil> findByPerfil(String perfil);
    public boolean existsByPerfil (String perfil);
}
