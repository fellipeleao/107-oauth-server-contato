package br.com.mastertech.contatooauth.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import br.com.mastertech.contatooauth.model.Usuario;

public class UsuarioPrincipalExtractor implements PrincipalExtractor 
{
    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(map.get("id").toString()));
        usuario.setName((String) map.get("name"));
        return usuario;	
    }
}
