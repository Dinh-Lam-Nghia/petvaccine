package fpt.fa.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
@RequestMapping("/customers")
public class CustomersController {
	
	@Autowired
	private VaccinationrecordsService vaccinationrecordsService;
	
	@Autowired
	private PetsService petsService;
	
	@Autowired
	private VaccinesService vaccinesService;
	
	@Autowired
	private VeterinariansService veterinariansService;
	
	@GetMapping("/history")
	public String list_vaccinationRecords(@RequestParam(name = "keyword", required = false) String keyword,  Model model) {
		if (keyword != null && !keyword.isEmpty()) {
			model.addAttribute("vaccinationrecords", vaccinationrecordsService.search(keyword));
		} else {
			model.addAttribute("vaccinationrecords", vaccinationrecordsService.findByDelete(1));
		}
		model.addAttribute("menu_appointments", "active");
        model.addAttribute("title", "PetVaccines");
		return "customers/history";
	}
	
	@GetMapping("/register")
	public String create_vaccinationrecords(Model model) {
		model.addAttribute("menu_vaccinationRecords", "active");
        model.addAttribute("title", "PetVaccines");
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(30);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String currentDate = futureDate.format(formatter);
	    Date sqlDate = Date.valueOf(currentDate);
	    VaccinationRecords vaccinationrecords = new VaccinationRecords();
	    vaccinationrecords.setNextDueDate(sqlDate);
	    vaccinationrecords.setStatus("Chưa tiêm");
        model.addAttribute("vaccinationrecords", vaccinationrecords);
        
        model.addAttribute("pets", petsService.findByDelete(1));
        model.addAttribute("vaccines", vaccinesService.findByDelete(1));
        model.addAttribute("veterinarians", veterinariansService.getAllVeterinarians());
		return "customers/register";
	}
	
	@PostMapping("/register")
	public String post_create_vaccinationrecords(@ModelAttribute("vaccinationrecords") VaccinationRecords vaccinationRecords) {
		vaccinationrecordsService.create(vaccinationRecords);
		return "redirect:/customers/history";
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
