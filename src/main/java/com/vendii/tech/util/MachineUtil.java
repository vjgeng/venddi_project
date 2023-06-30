package com.vendii.tech.util;

import com.vendii.tech.impl.MachineRefillEvent;
import com.vendii.tech.impl.MachineSaleEvent;
import com.vendii.tech.inf.IEvent;
import com.vendii.tech.inf.ISubscriber;

public class MachineUtil {
	
	public String randomMachine () {
		
		double random = Math.random() * 3;
		
		int finalRandom = (int) random;
		
		if (finalRandom < 1) {
		    return "001";
		  } else if (random < 2) {
		    return "002";
		  }
		  return "003";
	}
	
	public IEvent eventGenerator() {
		
		double random = Math.random();
		
		if (random < 0.5) {
		    int saleQty = (int) Math.random() < 0.5 ? 1 : 2; 
		    return new MachineSaleEvent(saleQty, randomMachine());
		  } 
		  	int refillQty = (int) Math.random() < 0.5 ? 3 : 5; // 3 or 5
		  	return new MachineRefillEvent(refillQty, randomMachine());
	}
	
	

}
