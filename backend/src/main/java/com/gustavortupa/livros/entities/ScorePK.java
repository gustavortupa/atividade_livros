package com.gustavortupa.livros.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ScorePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5588998924984266936L;

	@ManyToOne
	@JoinColumn(name="livro_id")
	private Livro livro;
	
	@ManyToOne
	@JoinColumn(name="leitor_id")
	private Leitor leitor;
	
	public ScorePK() {
		
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}
	
	
}
