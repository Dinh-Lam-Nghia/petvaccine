package fpt.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clinics")
public class clinicsController {
	@GetMapping("/list")
	public String list_clinics(Model model) {
		model.addAttribute("title", "Quản lý phòng khám");
		return "clinics/list";
	}

}
