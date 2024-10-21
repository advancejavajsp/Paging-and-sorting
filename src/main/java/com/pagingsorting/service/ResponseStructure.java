package com.pagingsorting.service;

public class ResponseStructure<T> {

	private int count;
	private T body;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	public ResponseStructure(int count, T body) {
		
		this.count = count;
		this.body = body;
	}
	
	
}
