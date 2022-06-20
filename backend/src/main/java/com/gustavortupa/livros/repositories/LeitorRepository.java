package com.gustavortupa.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavortupa.livros.entities.Livro;
import com.gustavortupa.livros.entities.Leitor;

public interface LeitorRepository extends JpaRepository<Leitor, Long>{
	
	Leitor findByEmail(String email);
}
