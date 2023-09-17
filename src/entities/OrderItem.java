package entities;

public class OrderItem {
	
	private Integer quantity;
	private Product product;
	
	public OrderItem(Integer quantity, Product product) {
		
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setPrice(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		Double sum = product.getPrice() * quantity; 
		return sum;
	}

	@Override
	public String toString() {
		return product + ", Quantity: " + quantity + ", Subtotal: $" + subTotal();
	}
	
	

}
