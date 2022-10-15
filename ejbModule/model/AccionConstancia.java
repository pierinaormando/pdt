package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ACCION_CONSTANCIA database table.
 * 
 */
@Entity
@Table(name="ACCION_CONSTANCIA")
@NamedQuery(name="AccionConstancia.findAll", query="SELECT a FROM AccionConstancia a")
public class AccionConstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ACCION_CONSTANCIA")
	private long idAccionConstancia;

	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	//bi-directional many-to-one association to Analista
	@ManyToOne
	@JoinColumn(name="ID_ANALISTA")
	private Analista analista;

	//bi-directional many-to-one association to Constancia
	@ManyToOne
	@JoinColumn(name="ID_CONSTANCIA")
	private Constancia constancia;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	public AccionConstancia() {
	}

	public long getIdAccionConstancia() {
		return this.idAccionConstancia;
	}

	public void setIdAccionConstancia(long idAccionConstancia) {
		this.idAccionConstancia = idAccionConstancia;
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

	public Constancia getConstancia() {
		return this.constancia;
	}

	public void setConstancia(Constancia constancia) {
		this.constancia = constancia;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}