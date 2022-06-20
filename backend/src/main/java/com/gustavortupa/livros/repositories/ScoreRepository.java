package com.gustavortupa.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavortupa.livros.entities.Livro;
import com.gustavortupa.livros.entities.Score;
import com.gustavortupa.livros.entities.ScorePK;
import com.gustavortupa.livros.entities.Leitor;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
}
