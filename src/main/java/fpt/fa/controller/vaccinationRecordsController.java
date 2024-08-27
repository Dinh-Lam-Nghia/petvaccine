package fpt.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/vaccinationrecords")
public class vaccinationRecordsController {
	
	@GetMapping("/list")
	public String list_vaccinationRecords(Model model) {
		model.addAttribute("menu_appointments", "active");
        model.addAttribute("title", "PetVaccines");
		return "vaccinationrecords/list";
	}
	
	@GetMapping("/create")
	public String create_vaccinationrecords(Model model) {
		model.addAttribute("menu_appointments", "active");
        model.addAttribute("title", "PetVaccines");
		return "vaccinationrecords/create";
	}
	
	

}
