package com.juego.service.servicios;

import com.juego.service.entidades.Juego;
import com.juego.service.repositorio.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoService {

	@Autowired
	private JuegoRepository juegoRepository;

	public List<Juego> getAll() {
		return juegoRepository.findAll();
	}

	public Juego getJuegoById(int id) {
		return juegoRepository.findById(id).orElse(null);
	}

	public Juego save(Juego Juego) {
		Juego nuevaJuego = juegoRepository.save(Juego);
		return nuevaJuego;
	}

	public List<Juego> byUsuarioId(int usuarioId) {
		return juegoRepository.findByUsuarioId(usuarioId);
	}
}
