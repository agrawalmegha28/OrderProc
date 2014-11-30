package npu.domain;

public class Tax {
	private String state;
	private double percent;
	
	public Tax(String state, double percent) {
		this.state = state;
		this.percent = percent;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}

}
