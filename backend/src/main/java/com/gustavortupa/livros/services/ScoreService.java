package com.gustavortupa.livros.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavortupa.livros.dtos.LivroDTO;
import com.gustavortupa.livros.dtos.ScoreDTO;
import com.gustavortupa.livros.entities.Livro;
import com.gustavortupa.livros.entities.Score;
import com.gustavortupa.livros.entities.Leitor;
import com.gustavortupa.livros.repositories.LivroRepository;
import com.gustavortupa.livros.repositories.ScoreRepository;
import com.gustavortupa.livros.repositories.LeitorRepository;

@Service
public class ScoreService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private LeitorRepository leitorRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	@Transactional
	public LivroDTO saveScore(ScoreDTO dto){
		
			Leitor leitor = leitorRepository.findByEmail(null);
			if (leitor == null) {
				leitor = new Leitor();
				leitor.setEmail(dto.getEmail());
				leitorRepository.saveAndFlush(leitor);
			}
			
			Livro livro = livroRepository.findById(dto.getLivroId()).get();
			
			Score score = new Score();
			score.setLivro(livro);
			score.setLeitor(leitor);
			score.setValue(dto.getScore());
			
			score = scoreRepository.saveAndFlush(score);
			
			double sum = 0;
			for(Score x: livro.getScores()) {
				sum += x.getValue();
			}
			
			double avg = sum / livro.getScores().size();
			livro.setScore(avg);
			livro.setCount(livro.getScores().size());
			
			livro = livroRepository.save(livro);
			
			
			return new LivroDTO(livro);
		}
	
}
