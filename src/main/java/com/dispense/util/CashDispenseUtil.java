package com.dispense.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashDispenseUtil {

	public Map<Integer,Integer> withdraw(int availableamt) {
		List<Integer> integers = new ArrayList<>();
		integers.add(100);
		integers.add(50);
		integers.add(20);
		integers.add(10);
		
		Map<Integer, Integer> output = new HashMap<>();
		output.put(100, 0);
		output.put(50, 0);
		output.put(10, 0);
		output.put(20, 0);

		Map<Integer, Integer> notes = new HashMap<Integer, Integer>();
		notes.put(100, 5);
		notes.put(50, 5);
		notes.put(10, 5);
		notes.put(20, 5);
		
		for (Integer key : integers) {
			while (availableamt >= key && notes.get(key) > 0) {
				availableamt = availableamt - key;
				int temp = output.get(key);
				temp++;
				output.put(key, temp);
				temp = notes.get(key);
				temp--;
				notes.put(key, temp);
			}
		}
		if(availableamt!=0){
			System.out.println("not enough denomination");
			return null;
		}
		return output;
	}

}
