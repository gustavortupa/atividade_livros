package com.gustavortupa.livros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavortupa.livros.dtos.LivroDTO;
import com.gustavortupa.livros.services.LivroService;

@RestController
@RequestMapping(value = "livros")
public class Livrosontroller {

	@Autowired
	LivroService livroService;
	
	@GetMapping
	public Page<LivroDTO> findAll(Pageable pageable){
		
		return livroService.findAll(pageable);
	
	}
	
	@GetMapping(value = "/{id}")
	public LivroDTO find(@PathVariable Long id){
		
		return livroService.findById(id);
	
	}
}
