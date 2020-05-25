package net.hka.si.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class Lab1ChannelsApplication {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-components.xml");
		
		SpringApplication.run(Lab1ChannelsApplication.class, args);
		
//		while(true) {
//			
//		}
		
		
		MessageChannel messageChannel = context.getBean("messageChannel", MessageChannel.class); 
		Message<String> message1 = MessageBuilder.withPayload( "Hello world - one!").build(); 
		Message<String> message2 = MessageBuilder.withPayload( "Hello world - two!").build(); 
		Message<String> message3 = MessageBuilder.withPayload( "Hello world - three!").build(); 
		System.out.println("B4 sending message1 to the channel"); messageChannel.send(message1); System.out.println("message1 is sent to the channel");
		System.out.println("B4 sending message2 to the channel"); messageChannel.send(message2); System.out.println("message2 is sent to the channel");
		System.out.println("B4 sending message3 to the channel"); messageChannel.send(message3); System.out.println("message3 is sent to the channel");
		//System.out.println("done sending messages");
	}

}
