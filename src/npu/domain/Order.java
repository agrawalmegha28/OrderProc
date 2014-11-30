package npu.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String code;
	private Customer customer;
	private List<OrderItem> orderItems;
	private double subtotal;
	private double tax;
	private double total;
	
	
	public Order(String newOrderCode) {
		code = newOrderCode;
		orderItems = new ArrayList<OrderItem>();
	}
	public void removeProduct(Product prod){
				
				//Go over existing order items
				for(int i = 0; i < getOrderItems().size(); i++){
					//Get one of the existing order item
					OrderItem existingOrderItem = getOrderItems().get(i);
					
					//Get the product in this existing order item
					Product existingProduct = existingOrderItem.getProduct();
					
					//If the product name matches
					if(prod.getName().equals(existingProduct.getName())){
						getOrderItems().remove(i);
						break;
					}
		}
	}
	public void addItem(OrderItem newOrderItem){
		//If we find the same product already ordered, set it to true
		boolean found = false;
		
		//New product ordered in new order item
		Product newProduct = newOrderItem.getProduct();
		
		//Go over existing order items
		for(int i = 0; i < getOrderItems().size(); i++){
			//Get one of the existing order item
			OrderItem existingOrderItem = getOrderItems().get(i);
			
			//Get the product in this existing order item
			Product existingProduct = existingOrderItem.getProduct();
			
			//If the product name matches
			if(newProduct.getName().equals(existingProduct.getName())){
				//found it
				found = true;
				//New quantity is existing order quantity + new order quantity
				int newQuantity = existingOrderItem.getQuantity() + newOrderItem.getQuantity();
				//add the new quantity
				existingOrderItem.setQuantity(newQuantity);
				break;
			}
			
				
			
		}
		//if not found we add the new order item
		if (!found)
			getOrderItems().add(newOrderItem);
		subtotal =  subtotal + newProduct.getPrice() * newOrderItem.getQuantity();
		
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
