package com.dispense.util;

import java.util.HashMap;
import java.util.Map;

public class CashDispenseUtil {

	int requestamt = 200;
	
	public Map<Integer,Integer> withdraw() {
		int availableamt = requestamt;
		Map<Integer, Integer> output= new HashMap<>();
		output.put(100, 0);
		output.put(50, 0);
		output.put(10, 0);
		
		Map<Integer, Integer> notes = new HashMap<Integer, Integer>();
		notes.put(100, 5);
		notes.put(50, 5);
		notes.put(10, 5);
		
		for (Integer key :notes.keySet()){
			while(availableamt>=key && notes.get(key)>0){
				availableamt = availableamt - key;
				int temp = output.get(key);
				temp++;
				output.put(key, temp);
				temp = notes.get(key);
				temp--;
				notes.put(key, temp);
			}
		}
		
		
		
		
		
		return null;
		

	}

}
