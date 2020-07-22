package com.uin2020.crud_registro.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uin2020.crud_registro.InterfaceService.IUsuarioService;
import com.uin2020.crud_registro.Interfaces.IUsuario;
import com.uin2020.crud_registro.Modelo.Usuario;


@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuario data;
	
	public List<Usuario> listar() {
		
		return (List<Usuario>) data.findAll();
	
	}

	@Override
	public Optional<Usuario> listarIdUsuario(int IdUsuario) {
		
		
		return data.findById(IdUsuario);
	}

	@Override
	public int save(Usuario u) {		
		int res=0;
		Usuario usuario=data.save(u);
		
		if(!usuario.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int IdUsuario) {
		data.deleteById(IdUsuario);
		
		
	}

	

}
