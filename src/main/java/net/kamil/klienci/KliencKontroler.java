package net.kamil.klienci;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;








@Controller
public class KliencKontroler {
	
	@Autowired
	private KlienciRepzytorium repo;


	@GetMapping("/klienci")
	public String listaKlientow(Model model) {
		
		List<Klienci> listaKlientow= repo.findAll();
		model.addAttribute("listaKlientow", listaKlientow);
		
		return "klienci";
	}
	
	@GetMapping("/klienci/new")
	public String showKlienciNowyForm(Model model) {
		
		model.addAttribute("klient", new Klienci());
		return "klient_form";
	}
	@PostMapping("/klienci/save")
	public String saveKlient(Klienci klient) {
		repo.save(klient);
		return "redirect:/klienci";
	}
	
	@GetMapping("klienci/delete/{id}")
	public String deleteKlienci(@PathVariable("id") Integer id, Model model) {

		repo.deleteById(id);
		return "redirect:/klienci";
	}
	


	

	
	
}
