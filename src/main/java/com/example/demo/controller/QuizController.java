package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	@GetMapping("/resultado")
	public String getMethodName(Model modelo, HttpSession session) {

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) session.getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
		}
		// holasaaaaaaa
		int puntos = 0;

		for (Integer punto : puntajes)
			puntos += punto;

		modelo.addAttribute("puntaje", puntos);

		return "resultados";
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public ModelAndView paginaInicio(Model modelo) {
		ModelAndView amav = new ModelAndView();
		amav.setViewName("index");
		return amav;
	}

	@GetMapping("/p1")
	public String getPag1(Model modelo, HttpServletRequest request) {
		request.getSession().invalidate();
		return "pregunta1";
	}

	@PostMapping("/p1")
	public String postPag1(@RequestParam String respuesta, HttpServletRequest request) {
		// TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p2";
	}

	@GetMapping("/p2")
	public String getPag2() {
		return "pregunta2";
	}

	@PostMapping("/p2")
	public String postPag2(@RequestParam String respuesta, HttpServletRequest request) {
		// TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		// return "redirect:/resultado";
		return "redirect:/pregunta3";
	}

	@GetMapping("/p3")
	public String getPag3() {
		return "pregunta3";
	}

	@PostMapping("/p3")
	public String postPag3(@RequestParam String respuesta, HttpServletRequest request) {
		// TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p4";
	}
	
	@GetMapping("/p4")
	public String getPag4() {
		return "pregunta4";
	}

	@PostMapping("/p4")
	public String postPag4(@RequestParam String respuesta, HttpServletRequest request) { // TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p5";
	}

	@GetMapping("/p5")
	public String getPagN() {
		return "pregunta5";
	}

	@PostMapping("/p5")
	public String postPagN(@RequestParam String respuesta, HttpServletRequest request) { // TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p6";
	}

	

	/*
	 * @GetMapping("/preguntaN") public String getPagN() { return "preguntaN"; }
	 * 
	 * @PostMapping("/preguntaN") public String postPagN(@RequestParam String
	 * respuesta, HttpServletRequest request) { // TODO: process POST request
	 * 
	 * @SuppressWarnings("unchecked") List<Integer> puntajes = (List<Integer>)
	 * request.getSession().getAttribute("puntos"); if (puntajes == null) { puntajes
	 * = new ArrayList<>(); request.getSession().setAttribute("puntos", puntajes); }
	 * 
	 * puntajes.add(Integer.parseInt(respuesta));
	 * request.getSession().setAttribute("puntos", puntajes);
	 * 
	 * return "redirect:/preguntaNN"; }
	 */
}
