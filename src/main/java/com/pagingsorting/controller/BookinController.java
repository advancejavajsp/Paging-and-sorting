package com.pagingsorting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pagingsorting.entity.Person;
import com.pagingsorting.service.BookinService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@Profile("default")
public class BookinController {

	@Autowired
	private BookinService bookinService;

	@PostMapping("/save")
	public ResponseEntity book(@RequestBody Person person) {

		return bookinService.bookService(person);
	}

	@GetMapping("/findall")
	public ResponseEntity getAll() {

		return bookinService.findAll();
	}
	@GetMapping("/findall/{field}")
	public ResponseEntity getAll(@PathVariable String field) {

		return bookinService.findAllSort(field);
	}
	@GetMapping("/findall/{num}/{size}")
	public ResponseEntity getAll(@PathVariable int num,@PathVariable int size) {

		return bookinService.findAllPage(num,size);
	}
	
	@PostMapping("/cook")
	public String setCookies(@Autowired HttpServletResponse response ) {
		
		Cookie c=new Cookie("java", "spring-bbot");
		Cookie c1=new Cookie("jdbc", "hibernate");
		
		response.addCookie(c1);
		response.addCookie(c);
		
		return "cookie added";
	}
	@GetMapping("/readcook")
	public String readCookies( @CookieValue String java,@CookieValue String jdbc ) {
		
		return java+" "+jdbc;
	}
	
	@PostMapping("/sess")
	public String setSession(@Autowired HttpSession session) {
		
		session.setAttribute("name",new Person());
		
		return "session added";
	}
	
	@PostMapping("/readsess")
	public Object readSession(@Autowired HttpSession session) {
		
		return  session.getAttribute("name");
	}
}
