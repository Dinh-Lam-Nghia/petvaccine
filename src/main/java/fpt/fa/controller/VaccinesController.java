package fpt.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vaccines")
public class VaccinesController {
	@GetMapping("/list")
	public String vaccines(Model model) {
		model.addAttribute("title", "Vaccines");
		model.addAttribute("menu_vaccines", "active");
		return "vaccines/list";
	}
	
	@GetMapping("/create")
	public String create_Petsowners(Model model) {
		model.addAttribute("title", "Vaccines");
		model.addAttribute("menu_vaccines", "active");
		return "vaccines/create";
	}
	
	@GetMapping("/edit")
	public String edit_Petsowners(Model model) {
		model.addAttribute("title", "Vaccines");
		model.addAttribute("menu_vaccines", "active");
		return "vaccines/edit";
	}
}
