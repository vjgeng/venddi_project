package com.vendii.tech.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vendii.tech.inf.IEvent;
import com.vendii.tech.inf.IPublishSubscribeService;
import com.vendii.tech.inf.ISubscriber;

public class MachinePublisher implements IPublishSubscribeService {
	
	
	Map<String, ISubscriber> eventMaps = new HashMap<String, ISubscriber>();
	

	public void publish(IEvent event) {
		
		
		  for (Map.Entry<String,ISubscriber> entry : eventMaps.entrySet()) {

			  if(entry.getValue() instanceof MachineSaleSubscriber) {
			  
				  MachineSaleSubscriber saleMachine = (MachineSaleSubscriber)	entry.getValue();
			  
				  MachineSaleEvent sale = (MachineSaleEvent) event;
			  
				  saleMachine.handle(sale);
			  
				  System.out.println(saleMachine);
			  
				  System.out.println(entry.getKey());
			  
			  }
			  
			  else { 
				  
				  MachineRefillSubscriber refillMachine = (MachineRefillSubscriber) entry.getValue();
				  
				  MachineRefillEvent refill = (MachineRefillEvent) event;
				  
				  refillMachine.handle(refill);
				  
				  System.out.println(refillMachine);
				  
				  System.out.println(entry.getKey());
			  }
		  }
		 
		
		
	}

	public void subscribe(String type, ISubscriber handler) {
		
		
		
		eventMaps.put(type, handler);
		
		
		System.out.println(eventMaps.size());
		
	}

	public void unsubscribe(String handler) {
		eventMaps.remove(handler);
	}

}
