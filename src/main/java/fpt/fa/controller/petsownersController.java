package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String list_Petsowners(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
		if (keyword != null && !keyword.isEmpty()) {
			model.addAttribute("petOwners", petOwnersService.search(keyword));
		} else {
			model.addAttribute("petOwners", petOwnersService.findByDelete());
		}
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
	public String post_create_Petsowners(@ModelAttribute("petOwners") PetOwners petOwners) {
		petOwnersService.create(petOwners);
		return "redirect:/petsowners/list";
	}

	@GetMapping("/edit")
	public String edit_Petsowners(@RequestParam(name = "id", required = true) int ownerID, Model model) {
		PetOwners petOwner = petOwnersService.findById(ownerID);
		if (petOwner != null) {
			model.addAttribute("menu_petsowners", "active");
			model.addAttribute("petOwners", petOwner);

			return "petsowners/edit";
		} else {

			return "redirect:/petsowners/list";
		}

	}

	@PostMapping("/edit")
	public String post_edit_Petsowners(@ModelAttribute("petOwners") PetOwners petOwners) {
		petOwnersService.updateById(petOwners);
		return "redirect:/petsowners/list";
	}

	@GetMapping("/delete")
	public String delete_Petsowners(@RequestParam("id") int ownerID) {
		petOwnersService.deleteById(ownerID);
		return "redirect:/petsowners/list";
	}

}
