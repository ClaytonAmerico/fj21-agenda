package br.com.caelum.agenda.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserirContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return "/WEB-INF/jsp/adiciona-contato.jsp";
	}

}
