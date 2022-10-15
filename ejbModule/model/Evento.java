package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EVENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EVENTO")
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FINAL")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	private String titulo;

	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="evento")
	private List<Constancia> constancias;

	//bi-directional many-to-one association to Justificacion
	@OneToMany(mappedBy="evento")
	private List<Justificacion> justificacions;

	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="evento")
	private List<Reclamo> reclamos;

	public Evento() {
	}

	public long getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Constancia> getConstancias() {
		return this.constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

	public Constancia addConstancia(Constancia constancia) {
		getConstancias().add(constancia);
		constancia.setEvento(this);

		return constancia;
	}

	public Constancia removeConstancia(Constancia constancia) {
		getConstancias().remove(constancia);
		constancia.setEvento(null);

		return constancia;
	}

	public List<Justificacion> getJustificacions() {
		return this.justificacions;
	}

	public void setJustificacions(List<Justificacion> justificacions) {
		this.justificacions = justificacions;
	}

	public Justificacion addJustificacion(Justificacion justificacion) {
		getJustificacions().add(justificacion);
		justificacion.setEvento(this);

		return justificacion;
	}

	public Justificacion removeJustificacion(Justificacion justificacion) {
		getJustificacions().remove(justificacion);
		justificacion.setEvento(null);

		return justificacion;
	}

	public List<Reclamo> getReclamos() {
		return this.reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public Reclamo addReclamo(Reclamo reclamo) {
		getReclamos().add(reclamo);
		reclamo.setEvento(this);

		return reclamo;
	}

	public Reclamo removeReclamo(Reclamo reclamo) {
		getReclamos().remove(reclamo);
		reclamo.setEvento(null);

		return reclamo;
	}

}