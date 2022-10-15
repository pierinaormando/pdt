package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ESTUDIANTE database table.
 * 
 */
@Entity
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	private BigDecimal generacion;

	@Column(name="ID_ESTUDIANTE")
	private BigDecimal idEstudiante;

	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="estudiante")
	private List<Constancia> constancias;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Justificacion
	@OneToMany(mappedBy="estudiante")
	private List<Justificacion> justificacions;

	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="estudiante")
	private List<Reclamo> reclamos;

	public Estudiante() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getGeneracion() {
		return this.generacion;
	}

	public void setGeneracion(BigDecimal generacion) {
		this.generacion = generacion;
	}

	public BigDecimal getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(BigDecimal idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public List<Constancia> getConstancias() {
		return this.constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

	public Constancia addConstancia(Constancia constancia) {
		getConstancias().add(constancia);
		constancia.setEstudiante(this);

		return constancia;
	}

	public Constancia removeConstancia(Constancia constancia) {
		getConstancias().remove(constancia);
		constancia.setEstudiante(null);

		return constancia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Justificacion> getJustificacions() {
		return this.justificacions;
	}

	public void setJustificacions(List<Justificacion> justificacions) {
		this.justificacions = justificacions;
	}

	public Justificacion addJustificacion(Justificacion justificacion) {
		getJustificacions().add(justificacion);
		justificacion.setEstudiante(this);

		return justificacion;
	}

	public Justificacion removeJustificacion(Justificacion justificacion) {
		getJustificacions().remove(justificacion);
		justificacion.setEstudiante(null);

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
		reclamo.setEstudiante(this);

		return reclamo;
	}

	public Reclamo removeReclamo(Reclamo reclamo) {
		getReclamos().remove(reclamo);
		reclamo.setEstudiante(null);

		return reclamo;
	}

}