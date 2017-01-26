
public class Kitchen {

	private int xPos;
	private int yPos;
	
	
	Kitchen(int x, int y){
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setXPos(int x){
		this.xPos = x;
	}
	
	public void setYPos(int y){
		this.yPos = y;
	}
	
	public int getXPos(){
		return this.xPos;
	}
	public int getYPos(){
		return this.yPos;
	}
	
}
