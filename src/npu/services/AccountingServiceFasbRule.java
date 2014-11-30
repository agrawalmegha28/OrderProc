package npu.services;

import java.util.ArrayList;
import java.util.List;

import npu.domain.Order;
import npu.domain.Tax;

public class AccountingServiceFasbRule implements AccountingService {
	private TaxService taxService;
	
	
	public AccountingServiceFasbRule() {
		List<Tax> taxes = new ArrayList<Tax>();
		taxes.add(new Tax("CA", 10));
		taxes.add(new Tax("MA", 6));
		taxes.add(new Tax("WY", 5));
		taxes.add(new Tax("TX", 7));
		taxes.add(new Tax("VA", 8));
		taxService = new SalesTaxService(taxes);
	}

	@Override
	public void recordNewOrder(Order order) {
		System.out.println("Applying Federal Accounting Rules");
		return;

	}

	@Override
	public double computeTax(Order order) {
		return taxService.computeTax(order);
	}

}
