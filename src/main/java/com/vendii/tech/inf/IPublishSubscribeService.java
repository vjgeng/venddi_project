package com.vendii.tech.inf;

public interface IPublishSubscribeService {
	
	public void publish(IEvent event);
	public void subscribe(String type, ISubscriber handler);
	public void unsubscribe(String key);
}
