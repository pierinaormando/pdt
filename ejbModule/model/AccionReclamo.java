package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ACCION_RECLAMO database table.
 * 
 */
@Entity
@Table(name="ACCION_RECLAMO")
@NamedQuery(name="AccionReclamo.findAll", query="SELECT a FROM AccionReclamo a")
public class AccionReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ACCION_RECLAMO")
	private long idAccionReclamo;

	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	//bi-directional many-to-one association to Analista
	@ManyToOne
	@JoinColumn(name="ID_ANALISTA")
	private Analista analista;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	//bi-directional many-to-one association to Reclamo
	@ManyToOne
	@JoinColumn(name="ID_RECLAMO")
	private Reclamo reclamo;

	public AccionReclamo() {
	}

	public long getIdAccionReclamo() {
		return this.idAccionReclamo;
	}

	public void setIdAccionReclamo(long idAccionReclamo) {
		this.idAccionReclamo = idAccionReclamo;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Analista getAnalista() {
		return this.analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Reclamo getReclamo() {
		return this.reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

}