package com.reuder.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reuder.domain.Agenda;
import com.reuder.repository.AgendaRepository;
import com.reuder.repository.PacienteRepository;

@Controller
public class HtmlResource {
	
	@Autowired
	AgendaRepository agendaRepository;
	@Autowired
	private AgendaRepository ar;
	@Autowired
	private PacienteRepository pr;

	@RequestMapping(value = "/index")
	public String index() {

		return "index";
	}

	/*
	 * @RequestMapping(value = "/login") public String loginx() { return
	 * "login/login"; }
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String email) {
		String mail =""+pr.findByEmail(email);
		if(mail != null ) {
			return "redirect:/agenda";
		}
		System.out.println("passou");
		return "/login/login";
	}
	@RequestMapping(value = "/agenda")
	public ModelAndView agendaList() {
		ModelAndView mv = new ModelAndView("agenda/index");
		Iterable<Agenda> agendas = ar.findAll();
		mv.addObject("agendas", agendas);
		return mv;

	}
	

}