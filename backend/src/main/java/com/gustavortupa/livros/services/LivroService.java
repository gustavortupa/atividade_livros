package com.gustavortupa.livros.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavortupa.livros.dtos.LivroDTO;
import com.gustavortupa.livros.entities.Livro;
import com.gustavortupa.livros.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Transactional(readOnly = true)
	public Page<LivroDTO> findAll(Pageable pageabale){
		Page<Livro> livros = livroRepository.findAll(pageabale);
		Page<LivroDTO> livroPages = livros.map(x -> new LivroDTO(x));
		return livroPages;
	}
	
	@Transactional(readOnly = true)
	public LivroDTO findById(Long id){
		Livro livro = livroRepository.findById(id).get();
		LivroDTO livroDTO = new LivroDTO(livro);
		return livroDTO;
	}
	
}
