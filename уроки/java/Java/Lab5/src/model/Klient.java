package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the klient database table.
 * 
 */
@Entity
@NamedQuery(name="Klient.findAll", query="SELECT k FROM Klient k")
public class Klient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String fio;

	private String pol;

	//bi-directional many-to-one association to Zakaz
	@OneToMany(mappedBy="klient")
	private List<Zakaz> zakazs;

	public Klient() {
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

	public String getPol() {
		return this.pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public List<Zakaz> getZakazs() {
		return this.zakazs;
	}

	public void setZakazs(List<Zakaz> zakazs) {
		this.zakazs = zakazs;
	}

	public Zakaz addZakaz(Zakaz zakaz) {
		getZakazs().add(zakaz);
		zakaz.setKlient(this);

		return zakaz;
	}

	public Zakaz removeZakaz(Zakaz zakaz) {
		getZakazs().remove(zakaz);
		zakaz.setKlient(null);

		return zakaz;
	}

}