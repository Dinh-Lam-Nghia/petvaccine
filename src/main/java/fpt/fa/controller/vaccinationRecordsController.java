package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.fa.entity.VaccinationRecords;
import fpt.fa.service.PetsService;
import fpt.fa.service.VaccinationrecordsService;
import fpt.fa.service.VaccinesService;
import fpt.fa.service.VeterinariansService;




@Controller
@RequestMapping("/vaccinationrecords")
public class vaccinationRecordsController {
	
	@Autowired
	private VaccinationrecordsService vaccinationrecordsService;
	
	@Autowired
	private PetsService petsService;
	
	@Autowired
	private VaccinesService vaccinesService;
	
	@Autowired
	private VeterinariansService veterinariansService;
	
	@GetMapping("/list")
	public String list_vaccinationRecords(@RequestParam(name = "keyword", required = false) String keyword,  Model model) {
		if (keyword != null && !keyword.isEmpty()) {
			model.addAttribute("vaccinationrecords", vaccinationrecordsService.search(keyword));
		} else {
			model.addAttribute("vaccinationrecords", vaccinationrecordsService.findByDelete(1));
		}
		model.addAttribute("menu_vaccinationRecords", "active");
        model.addAttribute("title", "PetVaccines");
		return "vaccinationrecords/list";
	}
	
	@GetMapping("/create")
	public String create_vaccinationrecords(Model model) {
		model.addAttribute("menu_vaccinationRecords", "active");
        model.addAttribute("title", "PetVaccines");
        model.addAttribute("vaccinationrecords", new VaccinationRecords());
        
        model.addAttribute("pets", petsService.findByDelete(1));
        model.addAttribute("vaccines", vaccinesService.findByDelete(1));
        model.addAttribute("veterinarians", veterinariansService.getAllVeterinarians());
		return "vaccinationrecords/create";
	}
	
	@PostMapping("/create")
	public String post_create_vaccinationrecords(@ModelAttribute("vaccinationrecords") VaccinationRecords vaccinationRecords) {
		vaccinationrecordsService.create(vaccinationRecords);
		return "redirect:/vaccinationrecords/list";
	}
	
	@GetMapping("/delete")
	public String delete_vaccinationrecords(@RequestParam("id") int recordID) {
		vaccinationrecordsService.deleteById(recordID);
		return "redirect:/vaccinationrecords/list";
	}

	@GetMapping("/edit")
	public String edit_vaccinationrecords(@RequestParam(name = "id", required = true) int recordID, Model model) {
		VaccinationRecords vaccinationRecords = vaccinationrecordsService.findById(recordID);
		if (vaccinationRecords != null) {
			model.addAttribute("menu_vaccinationRecords", "active");
			model.addAttribute("vaccinationRecords", vaccinationRecords);
	        model.addAttribute("title", "PetVaccines");
	        

	        model.addAttribute("pets", petsService.findByDelete(1));
	        model.addAttribute("vaccines", vaccinesService.findByDelete(1));
	        model.addAttribute("veterinarians", veterinariansService.getAllVeterinarians());

			return "vaccinationrecords/edit";
		} else {

			return "redirect:/vaccinationrecords/list";
		}

	}

	@PostMapping("/edit")
	public String post_edit_vaccinationrecords(@ModelAttribute("vaccinationRecords") VaccinationRecords vaccinationrecords) {
		vaccinationrecordsService.create(vaccinationrecords);
		return "redirect:/vaccinationrecords/list";
	}

}
