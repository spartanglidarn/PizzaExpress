
public class Crossings {

	private int xAxis;
	private int yAxis;
	private int deliveries;
	
	Crossings (int x,int y,int d){
		this.xAxis = x;
		this.yAxis = y;
		this.deliveries = d;
	}

	
	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public int getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(int deliveries) {
		this.deliveries = deliveries;
	}
	
	
	
}
