package net.itinajero.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity					//Indicamos que nuestra clase modelo es una entidad
@Table(name="noticias")//Indicamos el nombre de la tabla SQL de nuestra base de datos
public class Noticia {

	@Id													   //Indicamos que el atributo es la llave rpimaria de nuestra tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY)     //indicamos que se genera de forma automatica AI
	private int id;
	@Column(name="titulo",length=250,nullable=false)      //se usa para mapear ek atributo con la columna de la BBDD, se puede omitir si se llaman igual pero es aconsejable su uso
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;
	
	public Noticia(){
		this.fecha = new Date();
		this.estatus = "Activa";
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}
	
}
