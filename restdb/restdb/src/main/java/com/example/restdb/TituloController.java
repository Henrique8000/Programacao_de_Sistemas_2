package com.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TituloController {
	
	@Autowired
	private TituloRepo tituloRepo;
	
	@GetMapping("/api/titulos")
	public Iterable<Titulo> gettitulos() {
		Iterable<Titulo> titulos = tituloRepo.findAll();
		return titulos;
	}
	
	@PostMapping("/api/criar")
	public Titulo createTitulo(@RequestBody Titulo t) {
		return tituloRepo.save(t);
	}
	
}
