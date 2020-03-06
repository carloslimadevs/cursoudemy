package com.carloslima.udemyweb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.dto.CategoryDTO;
import com.carloslima.udemyweb.security.JWTUtil;
import com.carloslima.udemyweb.security.UserSpringSecurity;
import com.carloslima.udemyweb.services.CategoryService;
import com.carloslima.udemyweb.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	 private JWTUtil jwtUtil;

	@RequestMapping(value="/refresh_token",method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {

		UserSpringSecurity user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}

	
	
}
