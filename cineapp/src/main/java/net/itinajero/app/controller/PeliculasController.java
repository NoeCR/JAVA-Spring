package net.itinajero.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IDetalleService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utiles;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IDetalleService servicedetalles;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Pelicula> lista = servicePeliculas.buscarTodas(page);
	model.addAttribute("peliculas", lista);
	return "peliculas/listPeliculas";
	}

	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model){		
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request){
		
		if(result.hasErrors()){
			for(ObjectError error: result.getAllErrors()){
				System.out.println(error.getDefaultMessage());
			}
			System.out.println("Errores en el formulario");
			return "peliculas/formPelicula";
		}
		if(!multipart.isEmpty()){
			String nombreImagen = Utiles.guardarImagen(multipart,request);
			pelicula.setImagen(nombreImagen);
		}
		servicedetalles.insertar(pelicula.getDetalle());
		servicePeliculas.insertar(pelicula);		
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/peliculas/index";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model){
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		model.addAttribute("pelicula", pelicula);		
		return "peliculas/formPelicula";
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes){
		Pelicula p = servicePeliculas.buscarPorId(idPelicula);
		// Se elimina primero la pelicula y acto seguido el detalle de dicha pelicula
		servicePeliculas.eliminar(idPelicula);
		servicedetalles.eliminar(p.getDetalle().getId());
		attributes.addFlashAttribute("msg", "Pelicula Eliminada");
		return "redirect:/peliculas/index";
	}
	
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return servicePeliculas.buscarGeneros();
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
