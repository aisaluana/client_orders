package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	private LocalDateTime moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order(LocalDateTime moment, OrderStatus status, Client client) {

		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		Double sum = 0.0;
		for(OrderItem i : items) {
			sum += i.subTotal();
		}
		return sum;
	}

	
	@Override
	public String toString() {
		return "ORDER SUMMARY:\n"
				+ "Order moment: " + moment.format(fmt) +
				"\n" + "Order Status: " + status + "\n"
				+ "Client: " + client + "\n"
				+ "Order Items:\n" + items + "\n"
				+ "Total price: " + total();
	}
	
}
