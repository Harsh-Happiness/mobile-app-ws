package com.appdeveloperblog.app.ws.service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.appdeveloperblog.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

		UserDto createUser(UserDto user);
}
