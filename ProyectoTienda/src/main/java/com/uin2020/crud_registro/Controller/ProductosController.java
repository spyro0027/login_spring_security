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

import com.uin2020.crud_registro.Modelo.Productos;
import com.uin2020.crud_registro.Service.ProductosServiceImpl;

@Controller
@RequestMapping
public class ProductosController {

	@Autowired
	ProductosServiceImpl product;
	
	@GetMapping("/AdminProducts")
	public String listarProductos(Model model) {
		
		List<Productos> productos= product.listarProductos(); 
		model.addAttribute("productos", productos);
		
		return "AdminProductsList";
	}
	
	@GetMapping("/Userproducts")
	public String listarProductosU(Model model) {
		
		List<Productos> productos= product.listarProductos(); 
		model.addAttribute("productos", productos);
		
		return "UserProductsList";
	}
	
	@GetMapping("/newProduct")
	public String agregarProducto(Model model) {
		
		model.addAttribute("productos", new Productos());
		
		return "formularioProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String saveProduct(@Validated Productos p, Model model) {
		
		product.guardarProducto(p);
		
		return "redirect:/AdminProducts";
	}
	   
	@GetMapping("/updateProduct/{idProducto}")
	public String editarProducto(@PathVariable int idProducto, Model model) {
		
		Optional<Productos> productos= product.listarProductoPorId(idProducto);
		model.addAttribute("productos", productos);
		
		return "formularioProducto";
	}
	
	@GetMapping("/deleteProduct/{idProducto}")
	public String eliminarProducto(@PathVariable int idProducto, Model model) {
		
		product.eliminarProducto(idProducto);
		
		return "redirect:/AdminProducts";
	}
	
}