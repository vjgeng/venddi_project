package com.vendii.tech.impl;

import java.util.HashMap;
import java.util.Map;

import com.vendii.tech.inf.IEvent;
import com.vendii.tech.inf.IPublishSubscribeService;
import com.vendii.tech.inf.ISubscriber;

public class MachinePublisher implements IPublishSubscribeService {
	
	
	Map<String, ISubscriber> eventMaps = new HashMap<String, ISubscriber>();
	

	public void publish(IEvent event) {
		
		
		  for (Map.Entry<String,ISubscriber> entry : eventMaps.entrySet()) {

			  if(entry.getKey().equals("sale")) {
							 
				   MachineSaleSubscriber saleMachine = (MachineSaleSubscriber)	entry.getValue();
			  
				   MachineSaleEvent machineSaleEvent = (MachineSaleEvent) event;
				  
				   saleMachine.handle(machineSaleEvent);
			  
			  }
			  
			  else if(entry.getKey().equals("refill")) { 
				  
				   MachineRefillSubscriber refillMachine = (MachineRefillSubscriber) entry.getValue();
					
				   MachineRefillEvent refill = (MachineRefillEvent) event;
					 
				   refillMachine.handle(refill);
				
			  }
			  else { 
				  System.out.println("error");
			  }
			  
			  eventMaps.clear();
			  
		  }
		 
		
		
	}

	public void subscribe(String type, ISubscriber handler) {
		
		eventMaps.put(type, handler);
		
	}

	public void unsubscribe(String handler) {
		eventMaps.remove(handler);
	}

}
