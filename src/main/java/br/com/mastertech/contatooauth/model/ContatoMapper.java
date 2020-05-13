package br.com.mastertech.contatooauth.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.mastertech.contatooauth.dto.ConsultaContatoResponse;
import br.com.mastertech.contatooauth.dto.CreateContatoRequest;
import br.com.mastertech.contatooauth.dto.CreateContatoResponse;

@Component
public class ContatoMapper 
{
	public Contato fromCreateContatoRequestToContato(CreateContatoRequest createContatoRequest)
	{
		Contato contato = new Contato();
		contato.setTelefone(createContatoRequest.getTelefone());

		return contato;
	}
	
	public CreateContatoResponse toCreateContatoResponse(Contato contato)
	{
		CreateContatoResponse createContatoReponse = new CreateContatoResponse();
		createContatoReponse.setId(contato.getId());
		createContatoReponse.setIdUsuario(contato.getIdUsuario());
		createContatoReponse.setTelefone(contato.getTelefone());

		return createContatoReponse;
	}
	
	public List<ConsultaContatoResponse> toListConsultaContatoResponse(List<Contato> listaContato)
	{
		List<ConsultaContatoResponse> listaConsultaContatoResponse = new ArrayList<ConsultaContatoResponse>();
		
		for(Contato contato : listaContato)
		{
			ConsultaContatoResponse consultaContatoResponse = new ConsultaContatoResponse();
			consultaContatoResponse.setId(contato.getId());
			consultaContatoResponse.setTelefone(contato.getTelefone());
			
			listaConsultaContatoResponse.add(consultaContatoResponse);
		}

		return listaConsultaContatoResponse;
	}
}
