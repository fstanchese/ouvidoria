package br.usjt.ouvidoria.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.ouvidoria.dao.UsuarioDAO;
import br.usjt.ouvidoria.model.Usuario;

@Controller
public class LoginController {

	private UsuarioDAO daoUsuario;

	@Autowired
	public LoginController(UsuarioDAO daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "formlogin";
	}

	@RequestMapping("menu")
	public String menuForm(HttpSession session,Model model) {
		model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
		return "menuPrincipal";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		Usuario login = daoUsuario.buscaLoginUsuario(usuario);
		if (login.getId() != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:menu";
		}
		return "redirect:loginForm";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:menu";
	}
}
