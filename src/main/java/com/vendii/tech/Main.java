package com.vendii.tech;

import com.vendii.tech.impl.MachinePublisher;
import com.vendii.tech.impl.MachineRefillSubscriber;
import com.vendii.tech.impl.MachineSaleSubscriber;
import com.vendii.tech.inf.IEvent;
import com.vendii.tech.model.Machine;
import com.vendii.tech.util.MachineUtil;

public class Main {
	
	static MachineUtil machineUtil;
	
	public static void main(String args[]) {
		
		machineUtil = new MachineUtil();
		
		final Machine[] machines = {new Machine("001"), new Machine("002"), new Machine("003")};
		
		MachineSaleSubscriber saleSubscriber = new MachineSaleSubscriber(machines);
		
		final Machine[] machines2 =  {new Machine("001"), new Machine("002"), new Machine("003")};
		
		MachineRefillSubscriber refillSubscriber = new MachineRefillSubscriber(machines2);
		
		IEvent events = machineUtil.eventGenerator();
		
		MachinePublisher machinePublisher = new MachinePublisher();
		
		//machinePublisher.subscribe(events.type(), saleSubscriber);
		
	
		machinePublisher.subscribe(events.type(), refillSubscriber);
		machinePublisher.subscribe(events.type(), refillSubscriber);
		
		
		//machinePublisher.unsubscribe("refill");
		
		machinePublisher.publish(events);
		
	}

}
