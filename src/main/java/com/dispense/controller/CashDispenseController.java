package com.dispense.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dispense.util.CashDispenseUtil;

@Controller
public class CashDispenseController {
	
	 CashDispenseUtil cashdispenseutil = new CashDispenseUtil();
	
    @RequestMapping(value = "/withdraw/{debitnum}/{pin}/{amount}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
public Map<Integer, Integer> getcash(@PathVariable int debitnum, @PathVariable int pin, @PathVariable
		 int amount){
	Account account = new Account();
	account.setAmount(amount);
	/*account.setDebitnum(debitnum);
	account.setPin(pin);*/
	return cashdispenseutil.withdraw(account.getAmount());
    	
    }
   
    
    
}
