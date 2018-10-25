package com.fss.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fss.model.Student;

@Controller
public class StudentController {

	@RequestMapping(value="/test",method=RequestMethod.POST, consumes={"application/json"}, produces={"application/json"})
	public ResponseEntity<String> test(@Valid @RequestBody Student st, Errors error, BindingResult result)throws ValidationException
	{
		if(error.hasErrors())
		{
		throw new ValidationException(error.toString());
		}
		
		String str="Success";
		return new ResponseEntity<>(str, HttpStatus.OK);
		
	}
}
