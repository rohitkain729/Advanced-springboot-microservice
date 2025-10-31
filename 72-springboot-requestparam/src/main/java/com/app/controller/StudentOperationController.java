package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentOperationController {

	@GetMapping("/show")
	public ResponseEntity<String> showData(@RequestParam int sno, @RequestParam(required = false,defaultValue = " hero") String sname) {
//		when both are matching you can write it directly
		System.out.println("sno::" + sno + "::name::" + sname);
		return new ResponseEntity<String>(sno + " ---- " + sname, HttpStatus.OK);
	}
	
//	@GetMapping(value= {"/show/{sno}/{sname}","/show/{sname}"})
//	public ResponseEntity<String> showData2(@PathVariable(value = "sno",required = false) Integer sno, @PathVariable(value = "sname") String sname) {
////		when both are matching you can write it directly
//		System.out.println("sno::" + sno + "::name::" + sname);
//		return new ResponseEntity<String>(sno + " ---- " + sname, HttpStatus.OK);
//	}
	
	@GetMapping("/show/{sno}/sname")  // only one variable here
	public ResponseEntity<String> showData3(@PathVariable(value = "sno",required = false) Integer sno) {
//		when both are matching you can write it directly
		System.out.println("sno::" + sno );
		return new ResponseEntity<String>(sno +"::data", HttpStatus.OK);
	}
	
	@GetMapping("/show/sno/sname")  // this is simple url no varible here
	public ResponseEntity<String> showData3() {
//		when both are matching you can write it directly
	
		return new ResponseEntity<String>("method showData3", HttpStatus.OK);
	}
	
	@GetMapping("/show/sno/{sname}") // only one variable here
	public ResponseEntity<String> showData3(@PathVariable(value = "sname") String sname) {
//		when both are matching you can write it directly
		System.out.println("sno::" + sname );
		return new ResponseEntity<String>(sname +"::data", HttpStatus.OK);
	}
}
