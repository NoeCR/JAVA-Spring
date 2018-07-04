package net.itinajero.app.controller;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;

@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		List<Pelicula> peliculas = getLista();
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
	//Metodo para generar la lista de Objetos de Modelo (Pelicula)
	public List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		try{
			lista = new LinkedList<>();
			
			Pelicula p1 = new Pelicula(); 
			p1.setId(1);
			p1.setTitulo("Power Rangers");
			p1.setDuracion(120);
			p1.setClasificacion("B");
			p1.setGenero("Aventura");
			p1.setFechaEstreno(formatter.parse("02-05-2017"));
			
			lista.add(p1);
			
			Pelicula p2 = new Pelicula(); 
			p2.setId(2);
			p2.setTitulo("La Bella y la bestia");
			p2.setDuracion(132);
			p2.setClasificacion("A");
			p2.setGenero("Infantil");
			p2.setFechaEstreno(formatter.parse("20-05-2017"));
			p2.setImagen("bella.png");
			lista.add(p2);
			
			Pelicula p3 = new Pelicula(); 
			p3.setId(3);
			p3.setTitulo("Contratiempo");
			p3.setDuracion(106);
			p3.setClasificacion("B");
			p3.setGenero("Thriller");
			p3.setFechaEstreno(formatter.parse("28-05-2017"));
			p3.setImagen("contratiempo.png");
			lista.add(p3);
			
			Pelicula p4 = new Pelicula(); 
			p4.setId(4);
			p4.setTitulo("Kong la Isla Calavera");
			p4.setDuracion(118);
			p4.setClasificacion("B");
			p4.setGenero("Acción y Aventura");
			p4.setFechaEstreno(formatter.parse("06-06-2017"));
			p4.setImagen("kong.png");
			p4.setEstatus("Inactiva");
			lista.add(p4);
			

			Pelicula p5 = new Pelicula(); 
			p5.setId(5);
			p5.setTitulo("Life: Vida Inteligente");
			p5.setDuracion(104);
			p5.setClasificacion("B");
			p5.setGenero("Drama");
			p5.setFechaEstreno(formatter.parse("10-06-2017"));
			p5.setImagen("estreno5.png");
			p5.setEstatus("Activa");
			lista.add(p5);
			
			return lista;
		}catch(ParseException pex){
			System.out.println("Error" + pex);
			return null;
		}
		
		
		
	}
	//@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha){
		
		System.out.println("idPelicula: " + idPelicula);
		System.out.println("Horarios para la pelicula: " + fecha);
		
		//Buscar en la base de datos los horarios
		
		
		//String tituloPelicula = "Rapidos y furiosos";
		//int duracion = 136;
		//double precioEntrada = 50;		
		//model.addAttribute("titulo", tituloPelicula);
		//model.addAttribute("duracion", duracion);
		//model.addAttribute("precio", precioEntrada);
		return "detalle";
	}
	
}
