package net.itinajero.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //Auto_incrementado MySQL
	private int id;
	private String titulo;
	private int duracion=100;
	private String clasificacion="B";
	private String genero;
	private String imagen = "cinema.png";
	private Date fechaEstreno;
	private String estatus = "Activa";
	
	//@Transient  Con esta anoitacion se peuden ignorar los atributos para evitar recuperarlos de la base de datos
	@OneToOne
	@JoinColumn(name="idDetalle")
	private Detalle detalle;
	@OneToMany(mappedBy="pelicula", fetch=FetchType.EAGER)// cada vez que consultemos un registro pelicula tabien se consultara la tabla horarios para traer los que pertenezcan a dicha pelicula
	private List<Horario> horarios;
	
	
	public Pelicula() {
		
	}
	
	
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public Detalle getDetalle() {
		return detalle;
	}
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", estatus=" + estatus + "detalles: " + detalle + "]";
	}	
	
}
