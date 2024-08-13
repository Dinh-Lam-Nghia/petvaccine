package fpt.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
 


@Controller
//@RequestMapping("/login")
public class login {
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Đăng nhập");
		return "login_logout/login";
	}
	
	@GetMapping("/khoi_phuc_mat_khau")
	public String getMethodName(Model model) {
		model.addAttribute("title", "Khôi phục mật khẩu");
		return "login_logout/forgot";
	}
	
	
}
