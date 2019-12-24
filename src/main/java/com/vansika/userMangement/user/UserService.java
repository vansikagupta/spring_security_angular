package com.vansika.userMangement.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vansika.userMangement.security.CustomUserDetails;
import com.vansika.userMangement.security.UserModel;
import com.vansika.userMangement.security.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	private String getLoggedUserName(Authentication auth){
		String username;
		Object principal = auth.getPrincipal();
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		return username;
	}
	
	UserModel getLoggedInUser(Authentication auth){
		String username = getLoggedUserName(auth);
		
		Optional<UserModel> optionalUser = userRepository.findByUsername(username);
		UserModel user = optionalUser.get();
		return user;
	}

	public String addUser(UserModel newUser) {
		userRepository.save(newUser);
		return "Registration successfull";
	}

	public User getLoggedUserDetails(Authentication auth) {
		String username = getLoggedUserName(auth);
		
		Optional<UserModel> optionalUser = userRepository.findByUsername(username);
		UserModel user = optionalUser.get();
		return new User(user);
	}
}
