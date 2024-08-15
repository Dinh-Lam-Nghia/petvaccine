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
		return "petsowners/list";
	}
	
}
