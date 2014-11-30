package npu.services;

import java.util.List;

import npu.domain.Order;
import npu.domain.Tax;

public class SalesTaxService implements TaxService {
	private List<Tax> taxes;

	@Override
	public double computeTax(Order order) {
		double subtotal = order.getSubtotal();
		String state = order.getCustomer().getState();
		double stateTax = findTax(taxes, state);
		return (stateTax * subtotal)/100;
	}
	
	private double findTax(List<Tax> taxes, String state) {
		for(int i = 0; i < taxes.size(); i++){
			Tax tax = taxes.get(i);
			if(tax.getState().equals(state)){
				return tax.getPercent();
			}
		}
		return 0;
	}

	public SalesTaxService(List <Tax> taxes) {
		this.taxes = taxes;
	}

}
