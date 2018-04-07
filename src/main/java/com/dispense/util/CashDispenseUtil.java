package com.dispense.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BadRequestException;

import com.dispense.controller.Account;

public class CashDispenseUtil {

	List<Account> accounts = new ArrayList<>();

	public Map<Integer, Integer> withdraw(int availableamt) {
		if (availableamt == 0) {
			throw new BadRequestException("Invalid amount");
		}
		List<Integer> denominations = new ArrayList<>();
		denominations.add(150);
		denominations.add(110);
		denominations.add(100);
		denominations.add(80);
		denominations.add(70);
		denominations.add(60);
		denominations.add(50);
		denominations.add(40);
		denominations.add(20);
		denominations.add(10);

		Map<Integer, Integer> output = new HashMap<>();
		output.put(150, 0);
		output.put(110, 0);
		output.put(100, 0);
		output.put(80, 0);
		output.put(70, 0);
		output.put(60, 0);
		output.put(50, 0);
		output.put(40, 0);
		output.put(10, 0);
		output.put(20, 0);

		Map<Integer, Integer> notes = new HashMap<Integer, Integer>();
		notes.put(150, 50);
		notes.put(110, 50);
		notes.put(100, 50);
		notes.put(80, 50);
		notes.put(70, 50);
		notes.put(60, 50);
		notes.put(50, 50);
		notes.put(40, 50);
		notes.put(10, 50);
		notes.put(20, 50);

		for (Integer key : denominations) {
			while (availableamt >= key && notes.get(key) > 0) {
				availableamt = availableamt - key;
				output.put(key, (output.get(key) + 1));
				notes.put(key, notes.get(key) - 1);
			}
		}
		if (availableamt != 0) {
			return null;
		}

		return output;
	}

	public List<Account> listOfAccounts() {
		accounts.add(new Account(11000, "4561234561237894", "6057"));
		accounts.add(new Account(10000, "8888999977776666", "4561"));
		accounts.add(new Account(12000, "2222555599996666", "7894"));
		return accounts;
	}

	public Account findAccountbydebitnum(String debitnum) {
		for (Account acct : accounts) {
			if (acct.getDebitnum().equals(debitnum)) {
				return acct;
			}
		}
		return null;
	}

	public boolean validatepin(Account acct, String pin) {
		if (acct.getPin().equals(pin)) {

			return true;
		} else
			return false;
	}

}
