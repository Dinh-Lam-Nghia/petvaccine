package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fpt.fa.entity.PetOwners;
import fpt.fa.service.PetOwnersService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping; 


@Controller
@RequestMapping("/petsowners")
public class petsownersController {
	
	@Autowired
	private PetOwnersService petOwnersService;
	
	@GetMapping("/list")
	public String list_Petsowners(Model model) {
		model.addAttribute("menu_petsowners", "active");
		return "petsowners/list";
	}
	
	@GetMapping("/create")
	public String create_Petsowners(Model model) {
		model.addAttribute("petOwners", new PetOwners());
		model.addAttribute("menu_petsowners", "active");
		return "petsowners/create";
	}
	@PostMapping("/create")
	public String post_create_Petsowners(@ModelAttribute("petOwners") PetOwners petOwners, Model model, RedirectAttributes redirectAttributes) {
		petOwnersService.create(petOwners);
		
		redirectAttributes.addFlashAttribute("message", "Đăng ký thành công");
		return "redirect:/petsowners/create";
	}
	
	@GetMapping("/edit")
	public String edit_Petsowners(Model model) {
		model.addAttribute("menu_petsowners", "active");
		return "petsowners/edit";
	}
}
