package com.uin2020.crud_registro.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.uin2020.crud_registro.Modelo.Usuario;


public interface IUsuarioService {
	public List<Usuario> listar();
	public Optional<Usuario> listarIdUsuario(int IdUsuario);
	public int save(Usuario u);
	public void delete(int IdUsuario);

}
