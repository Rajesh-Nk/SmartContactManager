package com.rajesh.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajesh.sms.dao.UserRepo;
import com.rajesh.sms.entities.User;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepo userRepo;

	// This is Home Controller
	@GetMapping("/home")
	public String test(Model m) {
		m.addAttribute("tittle", "Home- Smart Contact Manager");
		return "home";
	}

	// This is About controller
	@GetMapping("/about")
	public String about(Model m) {
		m.addAttribute("tittle", "About- Smart Contact Manager");
		return "about";
	}

	// This is SignUp controller
	@GetMapping("/signup")
	public String signUp(Model m) {
		m.addAttribute("tittle", "SignUp- Smart Contact Manager");
		m.addAttribute("user", new User());
		return "signup";
	}
	
	//This is registration handler controller
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user")User user,@RequestParam(name="agreement",defaultValue ="false")boolean agreement, Model m) {
		System.out.println(agreement);
		
		if(!agreement) {
			System.out.println("You have not agreed Terms and condition");
			m.addAttribute("user", user);
			return "signup";
		}
		user.setEnabled(true);
		user.setImageUrl("default.png");
		user.setRole("normal");
		
		User result = userRepo.save(user);
		System.out.println("User has been saved successfully "+result);
		m.addAttribute("user",new User());
		return "signup";
	}
}
