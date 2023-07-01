package com.vendii.tech;

import java.util.Arrays;
import java.util.List;

import com.vendii.tech.impl.MachinePublisher;
import com.vendii.tech.impl.MachineRefillEvent;
import com.vendii.tech.impl.MachineRefillSubscriber;
import com.vendii.tech.impl.MachineSaleSubscriber;
import com.vendii.tech.inf.IEvent;
import com.vendii.tech.model.Machine;
import com.vendii.tech.util.MachineUtil;

public class Main {
	
	static MachineUtil machineUtil;
	static MachinePublisher machinePublisher;
	
	public static void main(String args[]) {
		
		machinePublisher = new MachinePublisher();
		
		machineUtil = new MachineUtil();
		
		final Machine[] machines = {new Machine("001"), new Machine("002"), new Machine("003")};
		final Machine[] machines2 = {new Machine("004"), new Machine("005"), new Machine("006")};
		List<IEvent> iEventListList = Arrays.asList(
				machineUtil.eventGenerator(),
				machineUtil.eventGenerator(), 
				machineUtil.eventGenerator(), 
				machineUtil.eventGenerator(), 
				machineUtil.eventGenerator()
        );
		
		
		for(IEvent e : iEventListList) {
			

		  if(e.type().equals("sale")) { 
			  MachineSaleSubscriber saleSubscriber = new MachineSaleSubscriber(machines); 
			  machinePublisher.subscribe(e.type(), saleSubscriber);
		  
		  } else { 
			  MachineRefillSubscriber refillSubscriber = new MachineRefillSubscriber(machines2); 
			  machinePublisher.subscribe(e.type(), refillSubscriber);
		  
		  
		  }

		  machinePublisher.publish(e);
		}
		  
		
		
	}

}
