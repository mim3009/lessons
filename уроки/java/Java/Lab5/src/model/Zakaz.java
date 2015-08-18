package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the zakaz database table.
 * 
 */
@Entity
@NamedQuery(name="Zakaz.findAll", query="SELECT z FROM Zakaz z")
public class Zakaz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cost;

	@Temporal(TemporalType.DATE)
	private Date dataoformlzak;

	@Temporal(TemporalType.DATE)
	private Date datavipzakaza;

	private String namezakazchik;

	private Integer numzak;

	//bi-directional many-to-one association to Klient
	@ManyToOne
	@JoinColumn(name="idklient")
	private Klient klient;

	//bi-directional many-to-one association to Parichmaher
	@ManyToOne
	@JoinColumn(name="idparichm")
	private Parichmaher parichmaher;

	//bi-directional many-to-one association to Price
	@ManyToOne
	@JoinColumn(name="idprice")
	private Price price;

	//bi-directional many-to-one association to Pricheska
	@ManyToOne
	@JoinColumn(name="idpricha")
	private Pricheska pricheska;

	//bi-directional many-to-one association to Zakazusl
	@OneToMany(mappedBy="zakaz")
	private List<Zakazusl> zakazusls;

	public Zakaz() {
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

	public Date getDataoformlzak() {
		return this.dataoformlzak;
	}

	public void setDataoformlzak(Date dataoformlzak) {
		this.dataoformlzak = dataoformlzak;
	}

	public Date getDatavipzakaza() {
		return this.datavipzakaza;
	}

	public void setDatavipzakaza(Date datavipzakaza) {
		this.datavipzakaza = datavipzakaza;
	}

	public String getNamezakazchik() {
		return this.namezakazchik;
	}

	public void setNamezakazchik(String namezakazchik) {
		this.namezakazchik = namezakazchik;
	}

	public Integer getNumzak() {
		return this.numzak;
	}

	public void setNumzak(Integer numzak) {
		this.numzak = numzak;
	}

	public Klient getKlient() {
		return this.klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Parichmaher getParichmaher() {
		return this.parichmaher;
	}

	public void setParichmaher(Parichmaher parichmaher) {
		this.parichmaher = parichmaher;
	}

	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Pricheska getPricheska() {
		return this.pricheska;
	}

	public void setPricheska(Pricheska pricheska) {
		this.pricheska = pricheska;
	}

	public List<Zakazusl> getZakazusls() {
		return this.zakazusls;
	}

	public void setZakazusls(List<Zakazusl> zakazusls) {
		this.zakazusls = zakazusls;
	}

	public Zakazusl addZakazusl(Zakazusl zakazusl) {
		getZakazusls().add(zakazusl);
		zakazusl.setZakaz(this);

		return zakazusl;
	}

	public Zakazusl removeZakazusl(Zakazusl zakazusl) {
		getZakazusls().remove(zakazusl);
		zakazusl.setZakaz(null);

		return zakazusl;
	}

}