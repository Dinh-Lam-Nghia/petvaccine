package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("vaccines", new Vaccines());
		model.addAttribute("title", "Vaccines");
		model.addAttribute("menu_vaccines", "active");
		return "vaccines/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("vaccines") Vaccines vaccines, Model model, RedirectAttributes redirectAttributes) {
		vaccinesService.create(vaccines);
			
		return "redirect:/vaccines/list";
	}
	
	@PostMapping("/edit/{vaccineID}")
	 public String showUpdateForm(@PathVariable("vaccineID") int vaccineID, Model model) {
	     Vaccines vaccines = vaccinesService.findById(vaccineID);
	     model.addAttribute("vaccines", vaccines);
	     return "vaccines/edit"; // Tên của JSP page chứa form cập nhật
	 }
	
	@PostMapping("/edit")
	public String update(@ModelAttribute("vaccines") Vaccines vaccines, Model model, RedirectAttributes redirectAttributes) {
		vaccinesService.update(vaccines);
		redirectAttributes.addFlashAttribute("message", "Update thành công");
		return "redirect:/vaccines/list";
	}
	
	@PostMapping("/delete/{vaccineID}")
    public String delete(@PathVariable("vaccineID") int vaccineID, RedirectAttributes redirectAttributes) {
		vaccinesService.delete(vaccineID);
        redirectAttributes.addFlashAttribute("message", "Item deleted successfully.");
        return "redirect:/vaccines/list";
    }
	
	@GetMapping("/search")
	public String search(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			@RequestParam(name = "nameVaccine") String nameVaccine) {
		
		Page<Vaccines> vaccines = vaccinesService.findVaccinesByName(nameVaccine, PageRequest.of(page - 1, size));
		model.addAttribute("vaccines", vaccines);
		model.addAttribute("currentPage", page);
		model.addAttribute("currentSize", size);
		return "vaccines/list";
	}
	
}
