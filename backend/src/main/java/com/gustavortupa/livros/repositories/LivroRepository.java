package com.gustavortupa.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavortupa.livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
