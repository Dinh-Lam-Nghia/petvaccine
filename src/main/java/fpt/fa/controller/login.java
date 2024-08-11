package fpt.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping; 


@Controller
//@RequestMapping("/login")
public class login {
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Đăng nhập");
		return "login_logout/login";
	}
	
}
