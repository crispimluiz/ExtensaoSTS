package br.edu.iftm.extensaoSTS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.iftm.extensaoSTS.domain.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{
	//Com essa Class não preciso criar um DAO - persistencia como banco de dados
	//@Query("Select a from Atividade a Where a.nome like %nome%
	public List<Atividade> findByNomeContaining(@Param("nome") String nome);
	
}
