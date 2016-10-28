package br.com.caelum.agenda.view;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.model.Contato;

public class ListaContatosLogic implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// Monta a lista de contatos
		Connection connection = (Connection) req.getAttribute("conexao");
		List<Contato> contatos = new ContatoDao(connection).getLista();
		
		// Guarda a lista no request
		req.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
