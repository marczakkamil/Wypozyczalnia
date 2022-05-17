package net.kamil.samochody;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import net.kamil.klienci.Klienci;

@Entity
public class Samochody {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 128, nullable = false, unique = true)
	private String name;
	
	@Column(length = 50, nullable = false, unique = false)
	private String wypo;
	
	private float price;
	
	@ManyToOne
	 @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name= "klienci_id" )
	private Klienci klienci;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Klienci getKlienci() {
		return klienci;
	}

	public void setKlienci(Klienci klienci) {
		this.klienci = klienci;
	}

	public String getWypo() {
		return wypo;
	}

	public void setWypo(String wypo) {
		this.wypo = wypo;
	}

	
	
}
