package com.letion.controllers;

import com.letion.dto.UserDTO;
import com.letion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = {"/", "/index.html", "/index"}, method = RequestMethod.GET)
	public String printWelcome() {
		return "index";
	}

	@RequestMapping(value = "/user/{login}", method = RequestMethod.GET, produces =  "application/json")
	public
	@ResponseBody
	UserDTO  getAllDestinations(@PathVariable("login") String login){
		UserDTO userDTO = userService.getByLogin(login);
		return userDTO;

	}



}
