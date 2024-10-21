package com.pagingsorting.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double balance;
	private List<Long> mobile;
	@CreationTimestamp
	private LocalDate date;
	@CreationTimestamp
	private LocalTime time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Person( String name, double balance) {
		
		this.name = name;
		this.balance = balance;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public List<Long> getMobile() {
		return mobile;
	}
	public void setMobile(List<Long> mobile) {
		this.mobile = mobile;
	}
	
	
	
	
}
