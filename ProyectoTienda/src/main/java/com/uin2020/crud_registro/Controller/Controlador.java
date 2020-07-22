package com.uin2020.crud_registro.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uin2020.crud_registro.InterfaceService.IUsuarioService;
import com.uin2020.crud_registro.Modelo.Usuario;



@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/admin")
	public String listar(Model model) {
		List<Usuario>usuarios=service.listar();
		model.addAttribute("usuarios", usuarios);
		return "AdminUserList";
	}
	
	@GetMapping("/user")
	public String listarU(Model model) {
		List<Usuario>usuarios=service.listar();
		model.addAttribute("usuarios", usuarios);
		return "UserList";
	}
	 
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuarios", new Usuario());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Usuario u, Model model) {
		service.save(u);
		return "redirect:/admin";
	}
	     
	//El botón actualizar manda a este metodo para actualizar
	@GetMapping("/editar/{IdUsuario}")
	public String editar (@PathVariable int IdUsuario, Model modelo) {
		Optional<Usuario> usuario=service.listarIdUsuario(IdUsuario);
		modelo.addAttribute("usuarios",usuario);
		return "form";
	}
	
	@GetMapping ("/eliminar/{IdUsuario}")
	public String delete (@PathVariable int IdUsuario,Model modelo) {
		service.delete(IdUsuario);
		
		return "redirect:/admin";
	}

}
