package com.uin2020.crud_registro.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class loginController {

	@GetMapping({"/","/login"})
	public String login() {
		return "index";
	}
	
	@GetMapping("/menuCategorias")
	public String menu() {
		return "menuCategorias";
	}
	
}
