package com.vansika.userMangement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vansika.userMangement.security.UserModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public void home()
	{
		System.out.print("Welcome");//display userdetails
	}
	//after login user details page
	@RequestMapping("/rest/user")
	public UserModel getUser(Authentication auth)
	{
		//find currently logged in user and send user details from DB to client
		return userService.getLoggedInUser(auth);
	}
	
	@RequestMapping("/rest/loginuser")
	public User getLoggedUser(Authentication auth)
	{
		//find currently logged in user and send user details from DB to client
		return userService.getLoggedUserDetails(auth);
	}
	
	
	@PostMapping("/registration")
	public void addUser(@RequestBody UserModel newUser)
	{
		userService.addUser(newUser);
		
	}
	
	@PostMapping("/test")
	public void test()
	{
		System.out.print("post done");
	}
}
