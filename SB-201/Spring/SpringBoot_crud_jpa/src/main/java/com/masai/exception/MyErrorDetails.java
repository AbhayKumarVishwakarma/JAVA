package com.masai.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private LocalDateTime ldt;
	private String msg;
	private String details;
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	public MyErrorDetails(LocalDateTime ldt, String msg, String details) {
		super();
		this.ldt = ldt;
		this.msg = msg;
		this.details = details;
	}
	public LocalDateTime getLdt() {
		return ldt;
	}
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "MyErrorDetails [ldt=" + ldt + ", msg=" + msg + ", details=" + details + "]";
	}
}
