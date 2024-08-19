package fpt.fa.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fpt.fa.entity.Account;
import fpt.fa.service.AccountService;
 


@Controller
//@RequestMapping("/login")
public class loginController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/login")
	public String login(HttpSession session,
						Model model) {
		if(session.getAttribute("username")!=null) {
			return "index";
		}
		model.addAttribute("title", "Đăng nhập");
		return "login_logout/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
            			@RequestParam("password") String password,
            			HttpSession session,
                        HttpServletResponse response,
                        RedirectAttributes redirectAttributes) {
		int isAuthenticated  = accountService.Login(username,password);
		if(isAuthenticated == -1) {
			redirectAttributes.addFlashAttribute("message", "Tài khoản không tồn tại");
			return "redirect:login_logout/login";
		}
		if(isAuthenticated == 0) {
			redirectAttributes.addFlashAttribute("message", "Mât khẩu không chính xác");
			return "redirect:login_logout/login";
		}
		
		redirectAttributes.addFlashAttribute("message", "Đăng nhập thành công");
		session.setAttribute("username", username);
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:index";
	}
	
	@GetMapping("/forgot")
	public String forgot(Model model) {
		model.addAttribute("title", "Khôi phục mật khẩu");
		return "login_logout/forgot";
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("title", "Đăng ký");
		return "login_logout/register";
	}
	@PostMapping("/register")
	public String register( @RequestParam("username") String username,
						    @RequestParam("password") String password,
						    @RequestParam("verify_password") String verify_password,
						    HttpSession session,
				            HttpServletResponse response,
				            RedirectAttributes redirectAttributes,
				            Model model) {
		boolean checkUsername = accountService.checkUserName(username);
		if(checkUsername == true ) {
			redirectAttributes.addFlashAttribute("message", "Tài khoản đã tồn tại");
			return "login_logout/register";
		}
		if(password != verify_password) {
			redirectAttributes.addFlashAttribute("message", "Mật khẩu không khớp");
			return "login_logout/register";
		}
		Account account = new Account( username, password, "Admin", "0123456789", 1,null);
		accountService.create(account);
		model.addAttribute("title", "Đăng ký");
		redirectAttributes.addFlashAttribute("message", "Đăng ký thành công");
		return "login_logout/register";
		}
	
	
}
