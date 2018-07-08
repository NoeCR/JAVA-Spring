package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Pelicula;

@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null; 
	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		
		// Ejercicio: Crear una nueva lista enlazada	
		// Ejercicio: Agregar los objetos Banner a la lista
		lista = new LinkedList<>();
		
		Banner b1 = new Banner(); 
		b1.setId(1);
		b1.setTitulo("Proximamente Kong La Isla Calavera");
		b1.setArchivo("slide1.jpg");			
		lista.add(b1);
		
		Banner b2 = new Banner(); 
		b2.setId(2);
		b2.setTitulo("Estreno La bella y la bestia");
		b2.setArchivo("slide2.jpg");			
		lista.add(b2);
		
		Banner b3 = new Banner(); 
		b3.setId(3);
		b3.setTitulo("Este mes no te pierdas Rapidos y Furiosos 8");
		b3.setArchivo("slide3.jpg");			
		lista.add(b3);
		
		Banner b4 = new Banner(); 
		b4.setId(4);
		b4.setTitulo("Estreno en Agosto - Jefe en Pañales");
		b4.setArchivo("slide4.jpg");			
		lista.add(b4);	
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insertar(Banner banner) {
		
		// Ejercicio: Implementar metodo
		lista.add(banner);
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	@Override
	public List<Banner> buscarTodos() {
		
		// Ejercicio: Implementar metodo
		return lista;
		
	}

}
