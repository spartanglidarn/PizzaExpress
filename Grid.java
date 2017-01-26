public class Grid {

	private Crossing xy[][];
	private int xAxis;
	private int yAxis;
	
	
	Grid(int x, int y){
		setXAxis(x);
		setYAxis(y);
		
		xy = new Crossing [x][y];
		//Create the grid array
		for (int i = 0 ; i < x ; i++) {
			
			for (int a = 0 ; a < y ; a++) {

			}
			
		}
	}
	
	public void setXAxis (int x){
		this.xAxis = x;
	}
	public void setYAxis (int y){
		this.yAxis = y;
	}
	public int getXAxis (){
		return this.xAxis;
	}
	public int getYAxis (){
		return this.yAxis;
	}

	public Crossing[][] getBoard(){
		return xy;
	}
	
	public void setBoardPos(int x,  int y, Crossing c){
		this.xy[x][y] = c;
	}
}
