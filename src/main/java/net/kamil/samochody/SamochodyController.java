package net.kamil.samochody;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.kamil.klienci.Klienci;
import net.kamil.klienci.KlienciRepzytorium;




@Controller
public class SamochodyController {

	@Autowired
	private SamochodyRepozytorium samoRepo;
	@Autowired
	private KlienciRepzytorium klientRepo;
	
	
	
	@GetMapping("/samochody/new")
	public String showNewCarForm(Model model) {
		List<Klienci> listaKlientow= klientRepo.findAll();
		model.addAttribute("samochod", new Samochody());
		model.addAttribute("listaKlientow", listaKlientow);
		
		return "samochod_form2";
	}
@PostMapping("/samochod/save")
public String saveSamochod(Samochody samochody) {
	samoRepo.save(samochody);
	
	return "redirect:/samochody";
}
	
	@GetMapping("/samochody")
	public String listaSamochodow(Model model) {
		List<Samochody> listaSamochodow = samoRepo.findAll();
		model.addAttribute("listaSamochodow", listaSamochodow);
		return "samochody";
	}
	
	@GetMapping("samochod/edit/{id}")
	public String showEditSamochodyForm(@PathVariable("id") Integer id, Model model) {
		
Samochody samochod=	samoRepo.findById(id).get();
model.addAttribute("samochod", samochod);

List<Klienci> listaKlientow= klientRepo.findAll();
model.addAttribute("listaKlientow", listaKlientow);
		return "samochod_form2";
		
	}
	
	@GetMapping("samochod/delete/{id}")
	public String deleteSamochody(@PathVariable("id") Integer id, Model model) {
		
		samoRepo.deleteById(id);
		
		return "redirect:/samochody";
	}
	
	
}
