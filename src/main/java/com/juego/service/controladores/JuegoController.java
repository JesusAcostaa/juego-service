package com.juego.service.controladores;

import java.util.List;

import com.juego.service.entidades.Juego;
import com.juego.service.servicios.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/juego")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;
	
	@GetMapping
	public ResponseEntity<List<Juego>> listarJuegos(){
		List<Juego> juegos = juegoService.getAll();
		if(juegos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(juegos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Juego> obtenerJuego(@PathVariable("id") int id){
		Juego juego = juegoService.getJuegoById(id);
		if(juego == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(juego);
	}
	
	@PostMapping
	public ResponseEntity<Juego> guardarJuego(@RequestBody Juego juego){
		Juego nuevoJuego = juegoService.save(juego);
		return ResponseEntity.ok(nuevoJuego);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Juego>> listarJuegosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Juego> juegos = juegoService.byUsuarioId(id);
		if(juegos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(juegos);
	}
	
}
