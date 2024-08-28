package fpt.fa.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fpt.fa.entity.Account;
import fpt.fa.entity.Position;
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
                        RedirectAttributes redirectAttributes,
                        Model model) {
		int isAuthenticated  = accountService.Login(username,password);
		if(isAuthenticated == -1) {
			System.out.print("Tài khoản không tồn tại");
			model.addAttribute("message", "Tài khoản không tồn tại");
			return "login_logout/login";
		}
		if(isAuthenticated == 0) {
			System.out.print("Mât khẩu không chính xác");
			model.addAttribute("message", "Mât khẩu không chính xác");
			return "login_logout/login";
		}
		Account account = accountService.checkAccount(username);
		session.setAttribute("displayname", account.getDisplayName());
		session.setAttribute("username", username);
		session.setAttribute("role", account.getIntID());
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
		System.out.print("Đăng nhập thành công");
		if(account.getIntID()==2) {
			return "redirect:/customers/history";
				}
		return "redirect:/";
	}
	
	@GetMapping("/forgot")
	public String forgot(HttpSession session,
						 Model model) {
		if(session.getAttribute("username")!=null) {
			return "index";
		}
		model.addAttribute("title", "Khôi phục mật khẩu");
		return "login_logout/forgot";
	}
	
	@PostMapping("/forgot")
	public String forgot(@RequestParam("username") String username,
						 @RequestParam("phone") String phone,
						 Model model) {
		if(!accountService.checkUserName(username)) {
			model.addAttribute("message", "Tài khoản không tồn tại");
			return "login_logout/forgot";
		}
		String newpass = accountService.forgotAccount(username, phone);
		if(newpass.equals("FALSE")) {
			model.addAttribute("message", "Số điện thoại không đúng");
			return "login_logout/forgot";
		}
		model.addAttribute("newpass", "Mật khẩu mới : " + newpass);
		model.addAttribute("title", "Khôi phục mật khẩu");
		return "login_logout/forgot";
	}
	@GetMapping("/register")
	public String register(HttpSession session, Model model) {
		if(session.getAttribute("username")!=null) {
			return "index";
		}
		model.addAttribute("title", "Đăng ký");
		return "login_logout/register";
	}
	@PostMapping("/register")
	public String register( @RequestParam("username") String username,
							@RequestParam("fullname") String fullname,
							@RequestParam("phone") String phone,
						    @RequestParam("password") String password,
						    @RequestParam("verify_password") String verify_password,
						    HttpSession session,
				            HttpServletResponse response,
				            RedirectAttributes redirectAttributes,
				            Model model) {
		boolean checkUsername = accountService.checkUserName(username);
		if(checkUsername == true ) {
			System.out.print("Tài khoản đã tồn tại");
			model.addAttribute("message", "Tài khoản đã tồn tại");
			return "login_logout/register";
		}
		if(!password.equals(verify_password)) {
			System.out.print(password+verify_password);
			System.out.print("Mật khẩu không khớp");
			model.addAttribute("message", "Mật khẩu không khớp");
			return "login_logout/register";
		}
		Position postion = new Position(2,"Customer",1);
		Account account = new Account( username, password, fullname, phone, 1,postion);
		accountService.create(account);
		model.addAttribute("message", "Đăng ký thành công");
		model.addAttribute("title", "Đăng ký");
		redirectAttributes.addFlashAttribute("message", "Đăng ký thành công");
		System.out.print("da dang ky");
		return "login_logout/register";
		}
	
	@GetMapping("/logout")
	public String logout(HttpServletResponse response, HttpSession session, Model model) {
		model.addAttribute("title", "Đăng ký");
		session.invalidate();
		Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
		return "login_logout/login";
	}
	
}
