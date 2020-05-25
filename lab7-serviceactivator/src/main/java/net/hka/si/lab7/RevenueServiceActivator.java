package net.hka.si.lab7;

import org.springframework.messaging.Message;

import net.hka.si.domain.Shiporder;

public class RevenueServiceActivator {
	private double revenue = 0.0;
	
	public double computeTotalCost(Message<Shiporder> order) {
		
		return order.getPayload().getItem().stream()
				.mapToDouble(item -> item.getPrice().doubleValue() * item.getQuantity().intValue())
				.sum();
	}
	
	
	public double calculateTotalRevenue(Message<Shiporder> order) {
		revenue += this.computeTotalCost(order);
		return revenue;
	}
	
	public void printTotalRevenue(Message<Shiporder> order) {
		System.out.println("Processing order: " + order.getPayload().getOrderid());
		this.calculateTotalRevenue(order);
		System.out.println("Revenue now up to: " + revenue);
	}
	
}
