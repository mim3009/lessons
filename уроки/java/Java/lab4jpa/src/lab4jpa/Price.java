package lab4jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;


/**
 * The persistent class for the price database table.
 * 
 */
@Entity
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	private Integer price;

	//bi-directional many-to-one association to Zakaz
	@OneToMany(mappedBy="price", fetch = EAGER, cascade = ALL)
	private List<Zakaz> zakazs;

	public Price() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<Zakaz> getZakazs() {
		return this.zakazs;
	}

	public void setZakazs(List<Zakaz> zakazs) {
		this.zakazs = zakazs;
	}

	public Zakaz addZakaz(Zakaz zakaz) {
		getZakazs().add(zakaz);
		zakaz.setPrice(this);

		return zakaz;
	}

	public Zakaz removeZakaz(Zakaz zakaz) {
		getZakazs().remove(zakaz);
		zakaz.setPrice(null);

		return zakaz;
	}

}