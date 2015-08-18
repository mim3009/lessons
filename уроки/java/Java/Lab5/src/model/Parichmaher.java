package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parichmaher database table.
 * 
 */
@Entity
@NamedQuery(name="Parichmaher.findAll", query="SELECT p FROM Parichmaher p")
public class Parichmaher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String fio;

	private Integer pay;

	private Integer staj;

	//bi-directional many-to-one association to Zakaz
	@OneToMany(mappedBy="parichmaher")
	private List<Zakaz> zakazs;

	public Parichmaher() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFio() {
		return this.fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public Integer getPay() {
		return this.pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public Integer getStaj() {
		return this.staj;
	}

	public void setStaj(Integer staj) {
		this.staj = staj;
	}

	public List<Zakaz> getZakazs() {
		return this.zakazs;
	}

	public void setZakazs(List<Zakaz> zakazs) {
		this.zakazs = zakazs;
	}

	public Zakaz addZakaz(Zakaz zakaz) {
		getZakazs().add(zakaz);
		zakaz.setParichmaher(this);

		return zakaz;
	}

	public Zakaz removeZakaz(Zakaz zakaz) {
		getZakazs().remove(zakaz);
		zakaz.setParichmaher(null);

		return zakaz;
	}

}