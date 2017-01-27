public class Grid {

	private int xy[][];
	private int xAxis;
	private int yAxis;
	
	
	Grid(int x, int y){
		setXAxis(x);
		setYAxis(y);
		
		xy = new int [x][y];

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

	public int[][] getBoard(){
		return xy;
	}
	
	public void setBoardPos(int x,  int y, int c){
		this.xy[x][y] = c;
	}
}
