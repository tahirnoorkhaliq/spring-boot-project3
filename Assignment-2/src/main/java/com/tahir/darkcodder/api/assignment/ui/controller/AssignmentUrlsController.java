package com.tahir.darkcodder.api.assignment.ui.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/assignment2")
public class AssignmentUrlsController {
// On a windows machine to find a processid use netstat -ano -p tcp |find "8080". 
	//To kill the process use taskkill /F /PID 1234 (instead of 1234 enter the founded processid).
	
	
	@GetMapping("/bank-services")
	public ModelAndView getBankAddress() {
		List<String> headers = Arrays.asList("ID", "Services","Address");
		List<Map<String, Object>> rows = new ArrayList<>();
		rows.add(Map.of("ID", "1", "Address", "Old Airport Road 75 Golden Towers", "Services", "wholesale banking"));
		rows.add(Map.of("ID", "2", "Address", "Mg Road - Bengaluru 76 25", "Services", "retail banking"));
		rows.add(Map.of("ID", "3", "Address", "R T Nagar 140 409", "Services", "treasury"));
		rows.add(Map.of("ID", "4", "Address", "Indira Nagar - Cmh Road 184 548", "Services", "auto loans"));
		rows.add(Map.of("ID", "5", "Address", "Halasuru 286 Mount Kailash", "Services", "two-wheeler loans"));
		rows.add(Map.of("ID", "6", "Address", "Kalyan Nagar 353 No 402", "Services", "personal loans"));
		rows.add(Map.of("ID", "7", "Address", "Seshadripuram 367 Meera Sadan", "Services", " loans against property"));
		rows.add(Map.of("ID", "8", "Address", "Yelahanka 371 Mvm Complex", "Services", "consumer durable loan"));
		rows.add(Map.of("ID", "9", "Address", "Cauvery Bhavan 509 Ground Floor", "Services", "lifestyle loan"));
		rows.add(Map.of("ID", "10", "Address", "Bannerghatta Road-Near Sagar Hospital", "Services", "credit cards"));		
        ModelAndView modelAndView = new ModelAndView();                
        modelAndView.setViewName("bank-services");
        modelAndView.addObject("bankName", "HDFC Bangalore");
        modelAndView.addObject("headers", headers);
        modelAndView.addObject("rows", rows);        
        return modelAndView;
	}
	
	@GetMapping("/bank-name")
    public ModelAndView welcome() {		
		List<String> headers = Arrays.asList("ID", "Address", "Pin Code", "City");
		List<Map<String, Object>> rows = new ArrayList<>();
		rows.add(Map.of("ID", "1", "Address", "Old Airport Road 75 Golden Towers", "Pin Code", "560017", "City", "Bangalore"));
		rows.add(Map.of("ID", "2", "Address", "Mg Road - Bengaluru 76 25", "Pin Code", "560001", "City", "Bangalore"));
		rows.add(Map.of("ID", "3", "Address", "R T Nagar 140 409", "Pin Code", "560032", "City", "Bangalore"));
		rows.add(Map.of("ID", "4", "Address", "Indira Nagar - Cmh Road 184 548", "Pin Code", "560038", "City", "Bangalore"));
		rows.add(Map.of("ID", "5", "Address", "Halasuru 286 Mount Kailash", "Pin Code", "560042", "City", "Bangalore"));
		rows.add(Map.of("ID", "6", "Address", "Kalyan Nagar 353 No 402", "Pin Code", "560043", "City", "Bangalore"));
		rows.add(Map.of("ID", "7", "Address", "Seshadripuram 367 Meera Sadan", "Pin Code", "560020", "City", "Bangalore"));
		rows.add(Map.of("ID", "8", "Address", "Yelahanka 371 Mvm Complex", "Pin Code", "560064", "City", "Bangalore"));
		rows.add(Map.of("ID", "9", "Address", "Cauvery Bhavan 509 Ground Floor", "Pin Code", "560009", "City", "Bangalore"));
		rows.add(Map.of("ID", "10", "Address", "Bannerghatta Road-Near Sagar Hospital 514 Uma Admiralty", "Pin Code", "560029", "City", "Bangalore"));
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bank-name");
        modelAndView.addObject("bankName", "HDFC");
        modelAndView.addObject("headers", headers);
        modelAndView.addObject("rows", rows);        
        return modelAndView;
    } 
	
}
