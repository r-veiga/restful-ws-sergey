package com.appsdeveloper.blog.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.blog.app.ws.service.UserService;
import com.appsdeveloper.blog.app.ws.shared.dto.UserDto;
import com.appsdeveloper.blog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloper.blog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users 
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String getUser() {
		return "HTTP GET :: UserController.getUser() ha sido invocado";
	}
	
	@PostMapping("")
	public UserRest createUser(@RequestBody UserDetailsRequestModel detalleDeUsuario) {
		System.out.println("HTTP POST :: UserController.createUser() ha sido invocado"); 
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(detalleDeUsuario, userDto);
		UserDto createdUser = userService.createUser(userDto);
		
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	
	@PutMapping("")
	public String updateUser() {
		return "HTTP PUT :: UserController.updateUser() ha sido invocado";
	}
	
	@DeleteMapping("")
	public String deleteUser() {
		return "HTTP DELETE :: UserController.deleteUser() ha sido invocado";
	}
}
