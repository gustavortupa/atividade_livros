package com.gustavortupa.livros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavortupa.livros.dtos.LivroDTO;
import com.gustavortupa.livros.dtos.ScoreDTO;
import com.gustavortupa.livros.services.LivroService;
import com.gustavortupa.livros.services.ScoreService;

@RestController
@RequestMapping(value = "scores")
public class ScoreController {

	@Autowired
	ScoreService scoreService;
	
	@PutMapping
	public LivroDTO saveScore(@RequestBody ScoreDTO score){
		LivroDTO livroDTO = scoreService.saveScore(score);
		return livroTO;
	
	}
	

}
