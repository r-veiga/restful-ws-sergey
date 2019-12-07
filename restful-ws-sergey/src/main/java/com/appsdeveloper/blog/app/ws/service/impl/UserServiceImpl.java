package com.appsdeveloper.blog.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloper.blog.app.ws.UserRepository;
import com.appsdeveloper.blog.app.ws.io.entity.UserEntity;
import com.appsdeveloper.blog.app.ws.service.UserService;
import com.appsdeveloper.blog.app.ws.shared.Utils;
import com.appsdeveloper.blog.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		if(userRepository.findUserByEmail(user.getEmail()) != null) { 
			throw new RuntimeException("El registro de usuario ya existe");
		}
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		
		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(publicUserId); 
		userEntity.setEncryptedPassword("test"); // asigno una contraseña por modificar algo el estado
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}
	
}