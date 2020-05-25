package net.hka.si.lab6;

import org.springframework.messaging.Message;

import net.hka.si.domain.Shiporder;

public class ShipOrderEnricher {
	public double computeTotal(Message<Shiporder> order) {
//		double sum = 0;
//		for (Item item : order.getPayload().getItem()) {
//			sum = sum + (item.getPrice().doubleValue() * item.getQuantity().intValue());
//		}
//		return sum;
		
		
		
//		return order.getPayload().getItem().stream()
//				.map(item -> item.getPrice().doubleValue() * item.getQuantity().intValue())
//				.reduce(0.0, Double::sum);
		
		return order.getPayload().getItem().stream()
				.mapToDouble(item -> item.getPrice().doubleValue() * item.getQuantity().intValue())
				.sum();
	}
}
