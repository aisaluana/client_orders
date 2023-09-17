package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		// Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois mostrar um sumário do pedido. Nota: o instante do pedido deve ser o instante do sistema: new Date().
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter Client Data:");
		
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth Date(DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		
		
		System.out.println("Enter Order Data:");
		
		LocalDateTime orderMoment = LocalDateTime.now();
		
		System.out.println("Status: ");
		String status = sc.next();
		sc.nextLine();
		
		Order order = new Order(orderMoment, OrderStatus.valueOf(status.toUpperCase()), client);
		
		System.out.println("How many items to this order? ");
		Integer quantity = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= quantity; i++) {
			System.out.printf("Enter #%d item Data:\n", i);
			
			System.out.println("Product name: ");
			String productName = sc.nextLine();
			
			
			
			System.out.println("Product price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
			
			Product product = new Product(productName, productPrice);
			
			System.out.println("Quantity: ");
			Integer productQuantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderitem = new OrderItem(productQuantity, product);
			
			order.addItem(orderitem);
			
		}
		
		System.out.print(order);
		
		sc.close();
	}

}
