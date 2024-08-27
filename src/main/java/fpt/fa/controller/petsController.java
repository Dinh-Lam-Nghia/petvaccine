package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.fa.entity.Pets;
import fpt.fa.service.PetOwnersService;
import fpt.fa.service.PetsService;
import org.springframework.web.bind.annotation.RequestParam;
 



@Controller
@RequestMapping("/pets")
public class petsController {
	@Autowired
	private PetsService petsService;
	@Autowired
	private PetOwnersService petOwnersServicel;
	
	
	@GetMapping("/list")
	public String list_pets(@RequestParam(name = "keyword", required = false) String keyword,  Model model) {
		if (keyword != null && !keyword.isEmpty()) {
			model.addAttribute("pets", petsService.search(keyword));
		} else {
			model.addAttribute("pets", petsService.findByDelete(1));
		}
		model.addAttribute("menu_pets", "active");
        model.addAttribute("title", "Quản lý thú cưng");
		return "pets/list";
	}
	
	@GetMapping("/create")
	public String create_pets(Model model) {	
		model.addAttribute("menu_pets", "active");	
		model.addAttribute("pets", new Pets());
		model.addAttribute("petowners", petOwnersServicel.findByDelete());
        model.addAttribute("title", "Thêm thú cưng mới");
		return "pets/create";
	}
	
	@PostMapping("/create")
	public String post_create_pets(@ModelAttribute("pets") Pets pets) {
	    petsService.create(pets);
	    return "redirect:/pets/list";
	}
	
	@GetMapping("/edit")
	public String edit_pets(@RequestParam("id") int petID, Model model) {
		Pets pet = petsService.findById(petID); 
		if (pet == null) {
	        // Xử lý trường hợp không tìm thấy pet
	        return "redirect:/pets/list"; // Hoặc trang lỗi
	    }
		model.addAttribute("pets", pet);
		model.addAttribute("petowners", petOwnersServicel.findByDelete());
		model.addAttribute("menu_pets", "active"); 
        model.addAttribute("title", "Chỉnh sửa thú cưng");
		return "pets/edit";
	}

	@PostMapping("/edit")
	public String update_pets(@ModelAttribute("pets") Pets pets) {
		petsService.create(pets);
		return "redirect:/pets/list";
	}
	
	@GetMapping("/delete")
	public String delete_pets(@RequestParam("id") int petID) {
		petsService.deleteById(petID);
		return "redirect:/pets/list";
	}
	
	
}
