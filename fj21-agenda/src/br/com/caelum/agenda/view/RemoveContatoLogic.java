package br.com.caelum.agenda.view;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.model.Contato;

public class RemoveContatoLogic implements Logica {
	
	public String executa(HttpServletRequest request, HttpServletResponse resonse) throws Exception {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.remove(contato);
		
		System.out.println("Excluindo contato... ");
		
		return "mvc?logica=ListaContatosLogic";
	}
}
