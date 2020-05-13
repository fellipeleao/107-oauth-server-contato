package br.com.mastertech.contatooauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mastertech.contatooauth.model.Contato;
import br.com.mastertech.contatooauth.repository.ContatoRepository;

@Service
public class ContatoService 
{
	@Autowired
	ContatoRepository contatoRepository;
	
	public Contato criaContato(Contato contato)
	{
		return contatoRepository.save(contato);
	}
	
	public List<Contato> consultaContatos(int idUsuario)
	{
       	List<Contato> listaContatos = contatoRepository.findContatosByIdUsuario(idUsuario);
        return listaContatos;
	}
}
