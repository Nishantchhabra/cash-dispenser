package com.dispense.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
	
	public Account(){
		
	}

	public Account(int amount,String debitnum,String pin) {
		this.amount=amount;
		this.debitnum=debitnum;
		this.pin=pin;
	}

	int amount;
	String debitnum;
	String pin;

	public String getDebitnum() {
		return debitnum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setDebitnum(String debitnum) {
		this.debitnum = debitnum;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}


}
