package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dopusl database table.
 * 
 */
@Entity
@NamedQuery(name="Dopusl.findAll", query="SELECT d FROM Dopusl d")
public class Dopusl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cost;

	private String name;

	//bi-directional many-to-one association to Zakazusl
	@OneToMany(mappedBy="dopusl")
	private List<Zakazusl> zakazusls;

	public Dopusl() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCost() {
		return this.cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Zakazusl> getZakazusls() {
		return this.zakazusls;
	}

	public void setZakazusls(List<Zakazusl> zakazusls) {
		this.zakazusls = zakazusls;
	}

	public Zakazusl addZakazusl(Zakazusl zakazusl) {
		getZakazusls().add(zakazusl);
		zakazusl.setDopusl(this);

		return zakazusl;
	}

	public Zakazusl removeZakazusl(Zakazusl zakazusl) {
		getZakazusls().remove(zakazusl);
		zakazusl.setDopusl(null);

		return zakazusl;
	}

}