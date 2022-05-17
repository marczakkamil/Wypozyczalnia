package net.kamil.klienci;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import net.kamil.samochody.Samochody;

@Entity
public class Klienci {
	
	public Klienci() {
	

	}
	public Klienci(Integer id) {

		this.id = id;

	}

	public Klienci(String name) {
		
		this.name = name;
	}


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	
    @Column(length = 45, nullable =true, unique = false)
    private String name;

    
    
    @OneToMany(mappedBy = "klienci" )
    private List<Samochody> samochody = new ArrayList<Samochody>();
    
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
	public List<Samochody> getSamochody() {
		return samochody;
	}
	public void setSamochody(List<Samochody> samochody) {
		this.samochody = samochody;
	}


	
}
