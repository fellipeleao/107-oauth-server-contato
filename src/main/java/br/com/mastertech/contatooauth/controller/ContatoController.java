package br.com.mastertech.contatooauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.contatooauth.dto.ConsultaContatoResponse;
import br.com.mastertech.contatooauth.dto.CreateContatoRequest;
import br.com.mastertech.contatooauth.dto.CreateContatoResponse;
import br.com.mastertech.contatooauth.model.Contato;
import br.com.mastertech.contatooauth.model.ContatoMapper;
import br.com.mastertech.contatooauth.model.Usuario;
import br.com.mastertech.contatooauth.service.ContatoService;

@RestController
public class ContatoController 
{
	@Autowired
	ContatoService contatoService;
	
	@Autowired
	ContatoMapper contatoMapper;
	
	@PostMapping("/contato")
	@ResponseStatus(value = HttpStatus.CREATED)
	public CreateContatoResponse criaContato(@RequestBody CreateContatoRequest createContatoRequest, @AuthenticationPrincipal Usuario usuario)
	{
		Contato contato = contatoMapper.fromCreateContatoRequestToContato(createContatoRequest);
		contato.setIdUsuario(usuario.getId());
		return contatoMapper.toCreateContatoResponse(contatoService.criaContato(contato));
	}
	
	@GetMapping("/contatos")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ConsultaContatoResponse> consultaContatos(@AuthenticationPrincipal Usuario usuario)
	{
		return contatoMapper.toListConsultaContatoResponse(contatoService.consultaContatos(usuario.getId()));
	}
}
