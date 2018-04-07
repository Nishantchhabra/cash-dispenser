package com.dispense.controller;

import java.util.Map;

import javax.ws.rs.BadRequestException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dispense.util.CashDispenseUtil;
import com.dispense.util.InsufficientDenominationException;
import com.dispense.util.InvalidPinException;

@Controller
public class CashDispenseController {

	CashDispenseUtil cashdispenseutil = new CashDispenseUtil();

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<Integer, Integer> withdrawCash(@RequestBody Account account)
			throws InsufficientDenominationException, InvalidPinException {
		cashdispenseutil.listOfAccounts();
		Account acct = cashdispenseutil.findAccountbydebitnum(account.getDebitnum());
		if (acct == null) {
			throw new BadRequestException("Invalid account");
		}
		if (!cashdispenseutil.validatepin(acct, account.getPin())) {
			throw new InvalidPinException("Invalid Pin");

		}
		if (account.getAmount() <= acct.getAmount()) {
			Map<Integer, Integer> response = cashdispenseutil.withdraw(account.getAmount());
			if (response == null) {
				throw new InsufficientDenominationException("Not enough cash in dispenser");
			}
			acct.setAmount(acct.getAmount() - account.getAmount());
			return response;
		}
		throw new BadRequestException("Not enough amount in account");
	}
}
