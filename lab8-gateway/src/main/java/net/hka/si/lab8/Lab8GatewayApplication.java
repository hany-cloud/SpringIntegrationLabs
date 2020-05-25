package net.hka.si.lab8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class Lab8GatewayApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		SpringApplication.run(Lab8GatewayApplication.class, args);
		
		// non SI Tightly-Coupled spring system works here
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-components.xml");
		
//		MessageChannel channel = context.getBean("requestChannel", MessageChannel.class);
//		Message<String> message = MessageBuilder.withPayload("Hello brave new world").build();
//		channel.send(message);
		
		// non SI Loosely-Coupled spring system works here
		PigLatinService service = context.getBean("latinService", PigLatinService.class);
		
		// synchronous
		//System.out.println(service.translate("Hello brave new world"));
		
		// asynchronous
		Future<String> future = service.translate("Hello brave new world"); 
		// do more work here in a real application 
		String serviceOutput = future.get(5000, TimeUnit.SECONDS); 
		System.out.println(serviceOutput);
		
		
		context.close();
		
	}

}
