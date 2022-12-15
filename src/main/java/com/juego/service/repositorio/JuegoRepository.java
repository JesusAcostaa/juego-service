package com.juego.service.repositorio;

import com.juego.service.entidades.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer>{

	List<Juego> findByUsuarioId(int usuarioId);
	
}
