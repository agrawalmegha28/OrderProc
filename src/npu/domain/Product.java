package npu.domain;

public class Product {
	private String name;
	private double price;
	
	public Product(String name,double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		 final int prime = 31;
	     int result = 1;
	     result = prime * result + getName().hashCode();  
	     return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (getName().equals(other.getName()))
            return true;
        return false;
	}

}
