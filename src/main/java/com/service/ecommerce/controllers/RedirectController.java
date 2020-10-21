package com.service.ecommerce.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RedirectController {
	
	/**
	 * Controlador provisório para redirecionar para a documentação.
	 * @param response
	 * @throws Exception
	 */
	@GetMapping()
	public void redirecionarParaDocumentacao(HttpServletResponse response) throws Exception {
		
		response.sendRedirect("/swagger-ui/");
	}
}
