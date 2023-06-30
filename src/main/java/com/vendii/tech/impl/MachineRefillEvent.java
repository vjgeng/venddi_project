package com.vendii.tech.impl;

import com.vendii.tech.inf.IEvent;

public class MachineRefillEvent implements IEvent {
	
	private int _refill;
	private String _machineId;
	
	public MachineRefillEvent(int _refill, String _machineId){
		this._refill=_refill;
		this._machineId=_machineId;
	}

	public String type() {
		return "refill";
	}

	public String machineId() {
		return this._machineId;
		
	}
	
	public int getRefillQuantity() { 
		return this._refill;
	}
	
	
	
}
