package com.example.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.Service.UserService;
import com.example.ecom.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/reg")
	public String insert()
	{
		return "reg";
	}
	
	  @PostMapping("/saveinsert") 
	  public String insetRegister(@ModelAttribute User user) 
	  { 
		  userService.insertUser(user);
		  return "reg"; 
	}
	  
	  @GetMapping("/login")
	  public String login(Model m)
	  {
		  m.addAttribute("user", new User());
		  return "login";
	  }
	  
	  @PostMapping("/loginform")
	  public String login(@ModelAttribute("user") User user,Model m)
	  {
		  User u=userService.loginAndEmail(user.getEmail(),user.getPassword());
		  if(u!=null)
		  {
			  return "reg";
		  }
		  m.addAttribute("error","Emial Id is worng password!!");
		  return "redirect:/login";
	  }
}
