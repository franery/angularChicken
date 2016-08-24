package com.chicken.presentacion.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SharedControlador {
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}

}
