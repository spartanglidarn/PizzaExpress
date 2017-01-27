
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	
	
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		Kattio io = new Kattio(System.in, System.out);

		
		//int nrOfTests = sc.nextInt();
	
		int nrOfTests = io.getInt();
		
		//sc.nextLine();
		int resultArr[] = new int[nrOfTests];
		int testCount = 0;
		//Loop for every testcase
		for (int i = 0; i < nrOfTests; i++){
			
			//set X and Y axis for the testcase grid.
			/*
			int xAxis = sc.nextInt();
			int yAxis = sc.nextInt();
			*/
			int xAxis = io.getInt();
			int yAxis = io.getInt();
			//Create the testcase grid.
			Grid g = new Grid(xAxis, yAxis);
			
			for(int y = 0; y < yAxis; y++){		//ROWS(y Axis)
				for (int x = 0; x < xAxis; x++){	//COLUMNS(xAxis)
					
					//take the deliv value of every crossing and put it in int variable
					//int crossVal = sc.nextInt();
					int crossVal = io.getInt();
					//put the crossing value on the grid position
					g.setBoardPos(x, y, crossVal);
					
				}

		}
			//Send the grid to checkDist and then check the distance from the kitchen to delivery point
			resultArr[testCount] = getShortestDist(g);
			testCount ++;
		}
		
		//run thru the resultArr and print out the block results
		for (int a = 0; a < resultArr.length; a ++){
			io.println(resultArr[a] + " blocks");
		}
		io.close();
	}

	public static int getShortestDist(Grid g){
		//get the gridsize
		Grid theGrid = g;
		int xAxis = theGrid.getXAxis();
		int yAxis = theGrid.getYAxis();
		int gridArr[][] = g.getBoard();
		ArrayList<Integer> movesMade = new ArrayList<Integer>();
		int blockCount = 0;
		
		//create kitchen object
		Kitchen k = new Kitchen(0, 0);

		
		//Make a nested loop to test the kitchen on every position on the grid.
		for (int y = 0; y < yAxis; y++){		//rows (YAxis)
			//set kitchen Y position
			k.setYPos(y);

			for (int x = 0; x < xAxis; x++){			//columns (XAxis)
				//reset blockcount
				blockCount = 0;
				//set kitchen X position
				k.setXPos(x);
				
				//loop thru the grid with the kitchen on a specific position.
				for (int ya = 0; ya < yAxis; ya ++){	//rows (YAxis)
					for (int xa = 0; xa < xAxis; xa ++){	//columns (XAxis)
						//check the distance only if there has been a delivery
						int cornerDeliv = gridArr[xa][ya];
						if (cornerDeliv > 0){
							
							int dist = checkDist(k.getXPos(), k.getYPos(), xa, ya);
							//Multiply the distance to the delivery by the amount of deliveries made
							int distAndDeliv = dist * cornerDeliv;
							blockCount += distAndDeliv;

						}
					}
				}
				//add distance to the movesMade arrayList
				movesMade.add(blockCount);
			}
		}
		//check for the smallest amounts of moves made
		int minBlockMoves = movesMade.indexOf(Collections.min(movesMade));
		return movesMade.get(minBlockMoves);
	}
	
	public static int checkDist(int kx, int ky, int gx, int gy){
		int xDist = 0;
		int yDist = 0;
		int dist = 0;
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
		
		dist = (xDist + yDist);
		return dist;
	}
	

	
}
