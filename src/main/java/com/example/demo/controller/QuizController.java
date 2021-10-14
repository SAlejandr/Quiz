package com.example.demo.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojos.Usuario;
import com.example.demo.repositories.UsuarioDao;

@Controller
public class QuizController {

	private final String[] GENERALES = { "Teclis", "Karl Franz", "Rapanse de Lyoness", "Tyrion", "Louen Leoncoeur",
			"Heinrich Kemmler", "Rakarth", "Durthu", "Ungrim", "Thorgrim", "Taurox", "Khazrak", "Queek" };

	@Autowired
	private UsuarioDao dao;

	@GetMapping("/resultado")
	public String getMethodName(Model modelo, HttpSession session) {

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) session.getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
		}

		int puntos = 0;

		for (Integer punto : puntajes)
			puntos += punto;

		String tipo = "", texto = "";

		if (puntos < 10)
			tipo = "Skaven";
		else if (puntos < 18)
			tipo = "No muerto";
		else if (puntos < 26)
			tipo = "Humanoide";
		else if (puntos < 34)
			tipo = "Elfico";
		else
			tipo = "Lord imperial";

		switch (tipo) {
		case "Skaven":
			texto = "Skavens : Crees en la supervivencia del más fuerte y que toda tactica es buena mientras te de la victoria,"
					+ " no importa si es jugando sucio, siempre y cuando no te hagan lo mismo. Basicamente, un niño rata con esteroides.";
			break;
		case "No muerto":
			texto = "Reyes Funerarios, Condes Vampiro y Costa del Vampiro: Empiezas a comprender que no todo vale para ganar, "
					+ "pero te faltan muchas cosas que aprender, dependes del spam e intentas ganar con numeros o calidad, "
					+ "por eso estas muerto en vida";
			break;

		case "Humanoide":
			texto = "Hombres Bestia, Hombres Lagartos y Pieles Verdes: Curtido en combate, hacer spam ya no se te hace necesario,"
					+ "aunque lo disfrutas. Ahora elijes y menejas mejor tus tropas, cuidate mucho, puedes tener una recaida en las "
					+ "manos de tus antiguos impulsos Skavens.";
			break;

		case "Elfico":
			texto = "Elfos Oscuros, Elfos Silvanos y Altos Elfos: Has alcanzado un cierto nivel de maestria en el combate, cada victoria te sacia "
					+ "y cada derrota te hace más fuerte. Resistes con firmeza los ataque, eliges bien tus tropas y atacas con impetud. Eres un rival "
					+ "digno de temer";
			break;

		case "Lord imperial":
			texto = "Bretonia e Imperio: Las batallas te han curtido a tal extremos que seleccionas tus tropas al milimetro y evitas las mañas, "
					+ "el juego justo inunda tus venas y siempre juegas dando lo mejor de ti y evitas las batallas sin sentido";
			break;
		}

		modelo.addAttribute("puntaje", puntos);
		modelo.addAttribute("tipo", tipo);
		modelo.addAttribute("texto", texto);

		return "resultado";
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
		return "redirect:/p3";
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
	public String getPag5() {
		return "pregunta5";
	}

	@PostMapping("/p5")
	public String postPag5(@RequestParam String respuesta, HttpServletRequest request) { // TODO: process POST request

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

	@GetMapping("/p6")
	public String getPag6() {
		return "pregunta6";
	}

	@PostMapping("/p6")
	public String postPag6(@RequestParam String respuesta, HttpServletRequest request) { // TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p7";
	}

	@GetMapping("/p7")
	public String getPag7() {
		return "pregunta7";
	}

	@PostMapping("/p7")
	public String postPag7(@RequestParam String respuesta, HttpServletRequest request) { // TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p8";
	}

	@GetMapping("/p8")
	public String getPag8() {
		return "pregunta8";
	}

	@PostMapping("/p8")
	public String postPag8(@RequestParam String respuesta, HttpServletRequest request) { // TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		String[] gnrls = respuesta.split(", ");

		Vector<String> generales = new Vector<>();

		for (String general : gnrls) {
			generales.add(general);
		}

		puntajes.add(darPuntosGnrl(generales));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p9";
	}

	private Integer darPuntosGnrl(Vector<String> generales) {

		int puntos = 1;
		Vector<String> generalesCorrectos = new Vector<>();

		for (String gnrl : GENERALES) {
			generalesCorrectos.add(gnrl);
		}

		for (String gnrl : generales) {

			if (generalesCorrectos.contains(gnrl) && puntos < 4) {
				puntos++;
				System.err.println(puntos);
			}

		}

		return puntos;
	}

	@GetMapping("/p9")
	public String getPag9() {
		return "pregunta9";
	}

	@PostMapping("/p9")
	public String postPag9(@RequestParam String respuesta, HttpServletRequest request) { // TODO: process POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		puntajes.add(Integer.parseInt(respuesta));
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/p10";
	}

	@GetMapping("/p10")
	public String getPag10() {
		return "pregunta10";
	}

	@PostMapping("/p10")
	public String postPag10(@RequestParam(defaultValue = "false") Boolean respuesta1,
			@RequestParam(defaultValue = "false") Boolean respuesta2,
			@RequestParam(defaultValue = "false") Boolean respuesta3,
			@RequestParam(defaultValue = "false") Boolean respuesta4, HttpServletRequest request) { // TODO: process
																									// POST request

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) request.getSession().getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
			request.getSession().setAttribute("puntos", puntajes);
		}

		int puntos = 0;

		if (respuesta1)
			puntos += 2;

		if (respuesta3)
			puntos += 2;

		if (respuesta2)
			puntos -= 1;

		if (respuesta4)
			puntos -= 1;

		if (puntos < 0)
			puntos = 0;

		puntajes.add(puntos);
		request.getSession().setAttribute("puntos", puntajes);

		return "redirect:/resultado";
	}

	@PostMapping("/tablaResultados")
	public String GuardarYMostrar(@RequestParam String nombre, Model modelo, HttpSession session) {

		@SuppressWarnings("unchecked")
		List<Integer> puntajes = (List<Integer>) session.getAttribute("puntos");
		if (puntajes == null) {
			puntajes = new ArrayList<>();
		}

		int puntos = 0;

		for (Integer punto : puntajes)
			puntos += punto;

		Usuario u = new Usuario(nombre, puntos);

		dao.save(u);

		ArrayList<Usuario> clasificatoria = (ArrayList<Usuario>) dao.findAll();

		modelo.addAttribute("usuarios", clasificatoria);

		return "redirect:/tablaResultados";
	}

	@GetMapping(value = "/tablaResultados")
	public String mostrarTabla(Model modelo) {

		ArrayList<Usuario> clasificatoria = (ArrayList<Usuario>) dao.findAll();

		modelo.addAttribute("usuarios", clasificatoria);

		return "tablita";
	}

	
}
