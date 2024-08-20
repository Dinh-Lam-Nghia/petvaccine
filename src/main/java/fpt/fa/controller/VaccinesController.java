package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.fa.entity.Vaccines;
import fpt.fa.service.VaccinesService;

@Controller
@RequestMapping("/vaccines")
public class VaccinesController {
	@Autowired
	private VaccinesService vaccinesService;
	
	@GetMapping("/list")
	public String vaccines(
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			Model model) {
		Page<Vaccines> vaccines = vaccinesService.getListVaccinesWithPaging(PageRequest.of(page - 1, size));
		model.addAttribute("vaccines", vaccines);
		model.addAttribute("currentPage", page);
		model.addAttribute("currentSize", size);
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
