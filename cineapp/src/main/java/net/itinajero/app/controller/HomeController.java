package net.itinajero.app.controller;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IHorariosService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utiles;

@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");	
	
	@Autowired
	private IPeliculasService serviceopeliculas;
	
	@Autowired
	private IBannersService serviceBanners; // Ejercicio : Solucion
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		
		List<String> fechas = Utiles.nextDays(4);
		
		List<Pelicula> peliculas = serviceopeliculas.buscarTodas();
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", fechas);
		model.addAttribute("banners", serviceBanners.buscarTodos());
		return "home";
	}
	@RequestMapping(value="/search", method= RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		
		List<String> fechas = Utiles.nextDays(4);		
		List<Pelicula> peliculas = serviceopeliculas.buscarTodas();
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", fechas);
		model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion
		return "home";
	}
	
	
	//@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	//@RequestMapping(value="/detail", method=RequestMethod.GET   [anotaciones usadas = @RequestParam("idMovie") @RequestParam("fecha")])
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha){
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", serviceopeliculas.buscarPorId(idPelicula));		
		return "detalle";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
