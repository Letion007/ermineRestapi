package com.letion.controllers;

import com.letion.dto.LoginPassDTO;
import com.letion.dto.UserDTO;
import com.letion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = {"/", "/index.html", "/index"}, method = RequestMethod.GET)
	public String printWelcome() {
		return "index";
	}

//	@RequestMapping(value = "/user/{login}", method = RequestMethod.GET, produces =  "application/json")
//	public
//	@ResponseBody
//	Map  getUser(@PathVariable("login") String login){
//		Map <String, Object> result = new HashMap();
//		UserDTO userDTO = userService.getByLogin(login);
//		result.put("token", "sdfjksdjfksjdf");
//		result.put("data", userDTO);
//		return result;
//	}


	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public
	@ResponseBody
	Map  getUser(@ModelAttribute("login") LoginPassDTO logpas){
		System.out.println("login - " + logpas);
		System.out.println("login - " + logpas.getLogin());
		System.out.println("pass - " + logpas.getPassword());
		Map <String, Object> result = new HashMap();
		UserDTO userDTO = userService.getByLogin("Petya");
		result.put("token", "sdfjksdjfksjdf");
		result.put("data", userDTO);
		return result;
	}

//	@RequestMapping(value="/user/addUser", method=RequestMethod.POST)
//	@ResponseBody
//	public String addUser(@ModelAttribute("user") User user) {
//
//		if (user != null) {
//			logger.info("Inside addIssuer, adding: " + user.toString());
//		} else {
//			logger.info("Inside addIssuer...");
//		}
//		users.put(user.getUsername(), user);
//		return "{\"success\":1}";
//	}

//	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
//	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
//		logger.info("Start createEmployee.");
//		emp.setCreatedDate(new Date());
//		empData.put(emp.getId(), emp);
//		return emp;
//	}
}
