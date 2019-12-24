package com.vansika.userMangement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vansika.userMangement.security.UserModel;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String home()
	{
		return "Welcome";//display userdetails
	}
	//after login user details page
	@RequestMapping("/user")
	public UserModel getUser(Authentication auth)
	{
		//find currently logged in user and send user details from DB to client
		return userService.getLoggedInUser(auth);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registration")
	public String addUser(@RequestBody UserModel newUser)
	{
		return userService.addUser(newUser);
		
	}
}
