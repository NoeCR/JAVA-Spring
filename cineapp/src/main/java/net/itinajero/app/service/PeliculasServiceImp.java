package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasServiceImp implements IPeliculasService{

	private List<Pelicula> lista = null;
	
	public PeliculasServiceImp(){

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
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
			
			
		}catch(ParseException pex){
			System.out.println("Error" + pex);			
		}
	}
	
	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for(Pelicula p: lista){
			if(p.getId()==idPelicula){
				return p;	
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);		
	}

	@Override
	public List<String> buscarGeneros() {
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		return generos;
	}

}
