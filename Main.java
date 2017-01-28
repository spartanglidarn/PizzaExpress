
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static int xDist;
	private static int yDist;
	private static int countDist;
	private static int xAxis;
	private static int yAxis;
	private static int blockCount;
	private static int cornerDeliv;
	private static int kitchenX;
	private static int kitchenY;
	private static int dist;
	private static int distAndDeliv;
	
	public static void main(String[] args) {

		//Scanner sc = new Scanner(System.in);
		Kattio io = new Kattio(System.in, System.out);

		int nrOfTests = io.getInt();
		//int nrOfTests = sc.nextInt();
		

		
		int resultArr[] = new int[nrOfTests];
		int testCount = 0;
		//Loop for every testcase
		for (int i = 0; i < nrOfTests; i++){

			//set X and Y axis for the testcase grid.
			/*
			int xAxis = sc.nextInt();
			int yAxis = sc.nextInt();
			*/
			xAxis = io.getInt();
			yAxis = io.getInt();
			//Create the testcase grid.
			Crossings c[] = new Crossings[xAxis * yAxis];
			int loopCounter = 0;
			int delivs;
			int loopX = 0;
			int loopY = 0;
			
			for (int xy = 0; xy < xAxis * yAxis; xy++){
				loopX ++;
				if( xy % xAxis == 0 ){
				    loopX = 0;
				    loopY ++;
				}
				
				delivs = io.getInt();
				c[loopCounter] = new Crossings(loopX, loopY, delivs);
				loopCounter ++;
			}
			

			//Send the grid to checkDist and then check the distance from the kitchen to delivery point
			resultArr[testCount] = getShortestDist(c);
			testCount ++;

		}
		
		//run thru the resultArr and print out the block results
		for (int a = 0; a < resultArr.length; a ++){
			io.println(resultArr[a] + " blocks");
		}

		io.close();
	}

	public static int getShortestDist(Crossings[] c){
		//get the gridsize

		//int xAxis = x;
		//int yAxis = y;

		ArrayList<Integer> movesMade = new ArrayList<Integer>();
		blockCount = 0;
		kitchenX = 0;
		kitchenY = 0;
		dist = 0;
		distAndDeliv = 0;
		
		//Create a loop to test the kitchen on every position on the grid.
		for (int xy = 0; xy<c.length; xy++){
			blockCount = 0;
			kitchenX ++;
			//if the loop is at the end of the x axis, set x to 0 and jump down to the next rox on y 
			if( xy % xAxis == 0 ){
			    kitchenX = 0;
			    kitchenY ++;
			}
			
			//On every position of the grid, test the delivery.
			for (int nestedXY = 0; nestedXY < c.length; nestedXY ++){
				//get the deliveries from the crossing
				cornerDeliv = c[nestedXY].getDeliveries();
				//if there has been deliveries to the crossing check the distance.
				if (cornerDeliv > 0){
					dist = checkDist(c[nestedXY].getxAxis(), c[nestedXY].getyAxis(),
							kitchenX, kitchenY);
					distAndDeliv = dist * cornerDeliv;
					blockCount += distAndDeliv;
				}
			}
			//add the moves to arrayList with all the possible distances for the kitchen.
			movesMade.add(blockCount);
		}
		

		//check for the smallest amounts of moves made
		int minBlockMoves = movesMade.indexOf(Collections.min(movesMade));
		return movesMade.get(minBlockMoves);
	}
	
	public static int checkDist(int kx, int ky, int gx, int gy){
		xDist = 0;
		yDist = 0;

		//if kitchen has a HIGHER value or the same value on X AXIS
		if (kx > gx){
			xDist = (kx - gx);
		}
		//if kitchen has LOWER value on X AXIS
		else{
			xDist = (gx - kx);
		}
		//if kitchen has HIGHER value or the same value on Y AXIS
		if (ky > gy){
			yDist = (ky - gy);
		}
		//if kitchen has LOWER value on Y AXIS
		else{
			yDist = (gy - ky);
		}
		
		countDist = (xDist + yDist);
		return countDist;
	}
	
}
