package com.bourntec.apmg.usermanagement.v1.queue;

public interface MessagePublisher {
	 void publish(String channelName, final String message);
}
