package lab4jpa;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;


/**
 * The persistent class for the zakazusl database table.
 * 
 */
@Entity
@NamedQuery(name="Zakazusl.findAll", query="SELECT z FROM Zakazusl z")
public class Zakazusl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	//bi-directional many-to-one association to Dopusl
	@ManyToOne
	@JoinColumn(name="iddopusl")
	private Dopusl dopusl;

	//bi-directional many-to-one association to Zakaz
	@ManyToOne(fetch = EAGER, cascade = ALL)
	@JoinColumn(name="idzakaz")
	private Zakaz zakaz;

	public Zakazusl() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dopusl getDopusl() {
		return this.dopusl;
	}

	public void setDopusl(Dopusl dopusl) {
		this.dopusl = dopusl;
	}

	public Zakaz getZakaz() {
		return this.zakaz;
	}

	public void setZakaz(Zakaz zakaz) {
		this.zakaz = zakaz;
	}

}