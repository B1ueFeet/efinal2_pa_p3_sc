package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Inventario;
import com.example.demo.service.IInventarioService;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {

	@Autowired
	private IInventarioService inventarioService;

	@GetMapping("/ingresar")
	public String paginaNuevoInventario(Inventario inventario) {
		return "vistaNuevoInventario";
	}

	@PostMapping("/nuevo")
	public String ingresarInventario(Inventario inventario) {
		this.inventarioService.ingresar(inventario.getNumero(), inventario.getCodigoBIndividual(), inventario.getId());
		return "redirect:/inventarios/ingresarInventario";
	}

}
