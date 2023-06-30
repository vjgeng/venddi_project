package com.vendii.tech.impl;

import com.vendii.tech.inf.IEvent;

public class MachineSaleEvent implements IEvent {
	
	private int _sold; 
	private String _machineId;
	
	public MachineSaleEvent(int _sold, String _machineId){ 
		this._sold=_sold;
		this._machineId=_machineId;
	}

	public String type() {
		return "sale";
	}

	public String machineId() {
		return this._machineId;
	}
	
	public int getSoldQuantity() { 
		return this._sold;
	}

}
