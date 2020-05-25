package net.hka.si.lab3;

import java.io.File;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;


public class FileSelector implements MessageSelector {

	/**
	 * weeds out File messages where the File name does not start with a particular string
	 * If payload is a File payload and starts with the filename 
	 * of “msg”, the message is rejected.
	 */
	@Override
	public boolean accept(Message<?> message) {
		if (message.getPayload() instanceof File && 
					((File) message.getPayload()).getName().startsWith("msg")) {
			return false;
		}
		return true;
	}

}
