package com.vendii.tech.impl;

import com.vendii.tech.inf.IEvent;
import com.vendii.tech.inf.ISubscriber;
import com.vendii.tech.model.Machine;

public class MachineRefillSubscriber implements ISubscriber{
	
	private Machine[] machines;
	private int remaining;
	
	public MachineRefillSubscriber(Machine[] machines) {
		this.machines=machines;
	}
	
	public void handle(MachineRefillEvent event) {
		
		  this.remaining = this.machines[2].stockLevel += event.getRefillQuantity();
		  IEvent result = (IEvent) event;
		  handle(result);
	}

	public void handle(IEvent event) {
		
		int count = 0; 
		
		if(count < 1) {
	
			if(remaining < 3) {
				
				new LowStockWarningEvent().warningLowStockWarningEvent();
				count++;
			}
			else { 
				new StockLevelOkEvent().warningStockLevelOkEvent();
				count++;
			}
		
		}
	}

}
