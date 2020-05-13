package br.com.mastertech.contatooauth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.mastertech.contatooauth.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Integer>
{
	@Query(value = "select * from contato where id_usuario = :idUsuario", nativeQuery = true)
	List<Contato> findContatosByIdUsuario(int idUsuario);
}