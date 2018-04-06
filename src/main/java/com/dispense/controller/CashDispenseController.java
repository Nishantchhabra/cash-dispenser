package com.dispense.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CashDispenseController {
	
    @RequestMapping(value = "/withdraw/{debitnum}/{pin}/{amount}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
public @ResponseBody  String getcash(@PathVariable String accountnum, @PathVariable String pin, @PathVariable
		 String amount){
	return "hello";
    	
    }
   
    
    
}
