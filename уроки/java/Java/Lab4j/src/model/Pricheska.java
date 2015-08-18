package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pricheska database table.
 * 
 */
@Entity
@NamedQuery(name="Pricheska.findAll", query="SELECT p FROM Pricheska p")
public class Pricheska implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cost;

	private String namepric;

	private String tipprich;

	//bi-directional many-to-one association to Zakaz
	@OneToMany(mappedBy="pricheska")
	private List<Zakaz> zakazs;

	public Pricheska() {
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

	public String getNamepric() {
		return this.namepric;
	}

	public void setNamepric(String namepric) {
		this.namepric = namepric;
	}

	public String getTipprich() {
		return this.tipprich;
	}

	public void setTipprich(String tipprich) {
		this.tipprich = tipprich;
	}

	public List<Zakaz> getZakazs() {
		return this.zakazs;
	}

	public void setZakazs(List<Zakaz> zakazs) {
		this.zakazs = zakazs;
	}

	public Zakaz addZakaz(Zakaz zakaz) {
		getZakazs().add(zakaz);
		zakaz.setPricheska(this);

		return zakaz;
	}

	public Zakaz removeZakaz(Zakaz zakaz) {
		getZakazs().remove(zakaz);
		zakaz.setPricheska(null);

		return zakaz;
	}

}