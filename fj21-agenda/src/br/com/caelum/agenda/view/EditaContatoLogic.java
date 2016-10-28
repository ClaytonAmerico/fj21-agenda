package br.com.caelum.agenda.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.model.Contato;

public class EditaContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));

		ContatoDao dao = new ContatoDao();
		contato = dao.pesquisa(id);

		req.setAttribute("id", contato.getId());
		req.setAttribute("nome", contato.getNome());
		req.setAttribute("endereco", contato.getEndereco());
		req.setAttribute("email", contato.getEmail());

		Calendar c = contato.getDataNascimento();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = s.format(c.getTime());

		req.setAttribute("dataNascimento", dataFormatada);

		return "/WEB-INF/jsp/altera-contato.jsp";

	}

}
