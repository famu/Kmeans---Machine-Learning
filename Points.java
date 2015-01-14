
public class Points {

	int x, y;
	float shortest;
	
	int cx,cy;  //for the coordinates of centroids.
	public Points(int xx, int yy) {
		x=xx;
		y=yy;
		
		shortest = 0;
		cx=0;
		cy=0;
	}

	
	//not used.
	void display(){
		System.out.println(" (" +x + " " + y + ")  centroid (" + cx + " " + cy+ ")" + "  distance = " + shortest );
	}
	
	
	
}
