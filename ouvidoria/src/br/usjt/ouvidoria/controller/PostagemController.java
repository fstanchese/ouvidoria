package br.usjt.ouvidoria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.ouvidoria.model.Postagem;
import br.usjt.ouvidoria.service.PostagemService;

@Controller
@Transactional
@RequestMapping("/postagens")
public class PostagemController {

	private PostagemService servicePostagem;

	@Autowired
	public PostagemController(PostagemService servicePostagem) {
		this.servicePostagem = servicePostagem;
	}

	@RequestMapping("/novo")
	public String addpostagem(Model model) {
		model.addAttribute("postagem", new Postagem());
		return "postagem/crud";
	}

	@RequestMapping(value = "/crudPostagem", method = RequestMethod.POST)
	public String crudpostagem(@Valid @ModelAttribute("postagem") Postagem postagem, BindingResult result,
			Model model, @RequestParam("fileName") MultipartFile fileName) throws IOException {

		if (!result.hasErrors()) {
			if (!fileName.isEmpty() && fileName.getSize() <= 20971520) {
				postagem.setImagem(fileName.getBytes());
			}
			if (postagem.getId() == null) {
				servicePostagem.salvar(postagem);
				return "redirect:/postagens/novo";
			} else {
				servicePostagem.salvar(postagem);
				return "redirect:/postagens";
			}
		} else {
			model.addAttribute("postagem", postagem);
			return "postagem/crud";
		}
	}

	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		if (id > 0) {
			Postagem postagem = servicePostagem.buscaPorId(id);
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(postagem.getImagem());
			response.getOutputStream().close();
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	}
	
}
