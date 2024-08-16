package fpt.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping; 


@Controller
@RequestMapping("/petsowners")
public class petsownersController {
	@GetMapping("/list")
	public String list_Petsowners(Model model) {
		model.addAttribute("menu_petsowners", "active");
		return "petsowners/list";
	}
	
	@GetMapping("/create")
	public String create_Petsowners(Model model) {
		model.addAttribute("menu_petsowners", "active");
		return "petsowners/create";
	}
	
	@GetMapping("/edit")
	public String edit_Petsowners(Model model) {
		model.addAttribute("menu_petsowners", "active");
		return "petsowners/edit";
	}
}
