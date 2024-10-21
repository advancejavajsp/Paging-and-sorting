package com.pagingsorting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagingsorting.dao.PaymentRepository;
import com.pagingsorting.dao.PersonDao;
import com.pagingsorting.entity.Payment;
import com.pagingsorting.entity.Person;

@Service
public class BookinService {

	@Autowired
	PersonDao personDao;
	
	@Autowired
	PaymentRepository paymentRepository;
	
//	@PostConstruct
//	public void intDb() {
//		List<Person> person=IntStream.rangeClosed(1, 200)
//				.mapToObj(i->new Person("name"+i,new Random().nextInt(10000))).toList();
//		
//		personDao.saveAll(person);
//	}
//	
	
	@Transactional
	public ResponseEntity<Person> bookService(Person person) {
		 personDao.save(person);
		
		 Payment p=new Payment();
		 p.setPrice(5000);
		 if(person.getBalance()>p.getPrice()) {
			 paymentRepository.save(p);
		 }
		 else {
			 throw new RuntimeException("less price");
		 }
		 return ResponseEntity.status(HttpStatus.CREATED).body(person);
	}
	
	public ResponseEntity<ResponseStructure> findAll() {
		List<Person> pers=personDao.findAll();
		
		return  ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure(pers.size(), pers) );
	}
	
	public ResponseEntity<ResponseStructure> findAllSort(String field) {
		List<Person> pers=personDao.findAll(Sort.by(Sort.Direction.DESC, field));
//		 personDao.findAll(Sort.by(field));
		
		return  ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure(pers.size(), pers) );
	}
	
	public ResponseEntity<ResponseStructure> findAllPage(int num,int pagesize) {
		Page<Person> pers=personDao.findAll(PageRequest.of(num, pagesize));
		
		return  ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure(pers.getSize(), pers) );
	}
	
	
}
