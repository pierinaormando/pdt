package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TUTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Tutor.findAll", query="SELECT t FROM Tutor t")
public class Tutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column(name="ID_TUTOR")
	private BigDecimal idTutor;

	private String tipo;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="ID_AREA")
	private Area area;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Tutor() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getIdTutor() {
		return this.idTutor;
	}

	public void setIdTutor(BigDecimal idTutor) {
		this.idTutor = idTutor;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}