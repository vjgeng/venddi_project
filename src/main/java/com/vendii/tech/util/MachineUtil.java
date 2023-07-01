package com.vendii.tech.util;

import com.vendii.tech.impl.MachineRefillEvent;
import com.vendii.tech.impl.MachineSaleEvent;
import com.vendii.tech.inf.IEvent;
import com.vendii.tech.inf.ISubscriber;

public class MachineUtil {
	
	public String randomMachine () {
		
		double random = Math.random() * 6;
		
		int finalRandom = (int) random;
		
		if (finalRandom < 1) {
		    return "001";
		  } else if (random < 2) {
		    return "002";
		  }
		    else if (random < 3) {
		    return "003";
		  }
		  else if (random < 4) {
			    return "004";
		  }
		  else if (random < 5) {
			    return "005";
		   }
		  return "006";
	}
	
	public IEvent eventGenerator() {
		
		double random = Math.random();
		
		if (random < 0.5) {
		    int saleQty = (int) Math.random() < 0.5 ? 1 : 2; 
		    return new MachineSaleEvent(saleQty, randomMachine());
		  } 
		else { 
			int refillQty = (int) Math.random() < 0.5 ? 3 : 5; // 3 or 5
		  	return new MachineRefillEvent(refillQty, randomMachine());
		  	
		}
	}
	
	

}
