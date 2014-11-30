package npu.services;

import npu.domain.*;

public class OrderProcessor {
	private AccountingService acctService;
	private InventoryService invService;
	
	public void setAcctService(AccountingService acctService) {
		this.acctService = acctService;
	}
	
	public OrderProcessor() {
	}
	
	public void newOrder(Order order) {
		acctService.recordNewOrder(order);
		double tax = acctService.computeTax(order);
		order.setTax(tax);
		order.setTotal(order.getSubtotal() + order.getTax());
		invService.adjustInventory(order);
	}

	public InventoryService getInvService() {
		return invService;
	}

	public void setInvService(InventoryService invService) {
		this.invService = invService;
	}
}