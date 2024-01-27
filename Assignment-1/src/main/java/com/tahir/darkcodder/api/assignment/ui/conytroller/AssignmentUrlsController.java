package com.tahir.darkcodder.api.assignment.ui.conytroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignment1")
public class AssignmentUrlsController {
// On a windows machine to find a processid use netstat -ano -p tcp |find "8080". 
	//To kill the process use taskkill /F /PID 1234 (instead of 1234 enter the founded processid).
	
	@GetMapping("/bank-name")
	public String getBankName() {
		return "Citi Bank";
	}
	
	@GetMapping("/bank-address")
	public String getBankAddress() {
		return "Near Westin Hotel 3 North, Koregaon Rd, Ghorpadi, Pune, Maharashtra";
	}
	
}
