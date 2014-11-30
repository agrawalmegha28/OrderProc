package npu.client;

import npu.domain.*;
import npu.services.AccountingService;
import npu.services.InventoryService;
import npu.services.OrderProcessor;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderApplication {
	public static void main(String args[]) {
		ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		OrderProcessor orderProc = (OrderProcessor) container.getBean("orderProcBean");
		InventoryService invService = (InventoryService) container.getBean("myInventoryService");
		
		Order houseHoldOrder = new Order("household");
		
		Customer megha = new Customer();
		megha.setName("Megha Agrawal");
		megha.setState("CA");
		houseHoldOrder.setCustomer(megha);
		
		System.out.println("Before order processed");
		invService.printCurrentInventory();
		
		Product tv = new Product("tv", 200);
		OrderItem tvOrderItem = new OrderItem();
		tvOrderItem.setProduct(tv );
		tvOrderItem.setQuantity(2);
		houseHoldOrder.addItem(tvOrderItem );
		
		Product sofa = new Product("sofa", 100);
		OrderItem sofaOrderItem = new OrderItem();
		sofaOrderItem.setProduct(sofa);
		sofaOrderItem.setQuantity(3);
		houseHoldOrder.addItem(sofaOrderItem);
		
		orderProc.newOrder(houseHoldOrder );
		
		System.out.println("After order processed");
		invService.printCurrentInventory();
		
		System.out.println("Subtotal : " + houseHoldOrder.getSubtotal());
		System.out.println("Tax : " + houseHoldOrder.getTax());
		System.out.println("Total : " + houseHoldOrder.getTotal());
		
	}
}
