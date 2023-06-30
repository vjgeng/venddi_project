package com.vendii.tech.impl;

import com.vendii.tech.inf.IEvent;
import com.vendii.tech.inf.ISubscriber;
import com.vendii.tech.model.Machine;

public class MachineSaleSubscriber implements ISubscriber{
	

	private Machine[] machines;
	private int remaining;
	
	public MachineSaleSubscriber(Machine[] machines) {
		this.machines=machines;
	}

	public void handle(MachineSaleEvent event) {
		
		  this.remaining = this.machines[2].stockLevel -= event.getSoldQuantity();
		  IEvent result = (IEvent) event;
		  handle(result);
	}

	public void handle(IEvent event) {
		 
		System.out.println("remaining: " + this.remaining);
		
	}

}
