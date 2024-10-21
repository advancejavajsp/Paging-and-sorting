package com.pagingsorting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.pagingsorting.entity.Person;
import com.pagingsorting.service.BookinService;

@RestController
@Profile("test" )
public class BookinControllertest {

	@Autowired
	private BookinService bookinService;

	
	public ResponseEntity book(@RequestBody Person person) {

		return bookinService.bookService(person);
	}

	@GetMapping("/findalls")
	public ResponseEntity getAll() {

		return bookinService.findAll();
	}
	@GetMapping("/findalls/{field}")
	public ResponseEntity getAll(@PathVariable String field) {

		return bookinService.findAllSort(field);
	}
	@GetMapping("/findalls/{num}/{size}")
	public ResponseEntity getAll(@PathVariable int num,@PathVariable int size) {

		return bookinService.findAllPage(num,size);
	}
}
