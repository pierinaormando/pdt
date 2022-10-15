package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AREA database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AREA")
	private long idArea;

	private String area;

	//bi-directional many-to-one association to Tutor
	@OneToMany(mappedBy="area")
	private List<Tutor> tutors;

	public Area() {
	}

	public long getIdArea() {
		return this.idArea;
	}

	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Tutor> getTutors() {
		return this.tutors;
	}

	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	public Tutor addTutor(Tutor tutor) {
		getTutors().add(tutor);
		tutor.setArea(this);

		return tutor;
	}

	public Tutor removeTutor(Tutor tutor) {
		getTutors().remove(tutor);
		tutor.setArea(null);

		return tutor;
	}

}