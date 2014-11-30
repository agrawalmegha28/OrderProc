package npu.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import npu.domain.Order;
import npu.domain.OrderItem;
import npu.domain.Product;

public class MyInventoryService implements InventoryService {
	private Map<Product, Integer> inventory; 
	@Override
	public void adjustInventory(Order order) {
		List<OrderItem> orderItems = order.getOrderItems();
		for(int i=0; i < orderItems.size(); i++){
			OrderItem o = orderItems.get(i);
			Product p = o.getProduct();
			int q = o.getQuantity();
			if(inventory.containsKey(p)){
				Integer existingCount = inventory.get(p);
				if(existingCount > q){
					existingCount = existingCount - q;
					inventory.put(p, existingCount);
				}
			}
		}
		
	}
	public MyInventoryService() {
		inventory = new HashMap<Product, Integer>();
		Product sofa = new Product("sofa", 100);
		Product chair = new Product("chair",200);
		Product table = new Product("table",120);
		Product tv = new Product("tv",200);
		Product game = new Product("game",10);
		inventory.put(sofa , 10);
		inventory.put(chair , 10);
		inventory.put(table , 12);
		inventory.put(tv , 20);
		inventory.put(game , 10);
		
	}

	@Override
	public void printCurrentInventory() {
		for(Product key : inventory.keySet()){
			System.out.println("Product : " + key.getName() + " Quantity : " + inventory.get(key));
		}
		
	}

}
