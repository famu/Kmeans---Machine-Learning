import java.awt.DisplayMode;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Kmeans {

	public static void main(String[] args) {
		
		
		int pts[][]= {{ 48, 46, 41, 51, 28, 38, 17, 45, 39, 43, 42, 41, 38, 44, 41, 41, 40, 48, 41, 36, 42, 46, 44, 50, 33, 47, 26, 32, 37, 37, 41, 43, 40, 38, 33, 40, 45, 33, 30, 42, 41, 38, 22, 29, 44, 43, 38, 43, 46, 29, 47, 48, 47, 41, 30, 45, 47, 46, 46, 29, 40, 50, 43, 47, 41, 31, 25, 36, 25, 39, 43, 42, 49, 43, 35, 37, 43, 39, 40, 49, 45, 45, 40, 42, 44, 36, 42, 49, 42, 31, 38, 20, 37, 41, 48, 26, 24, 39, 41, 33, 46, 40, 34, 41, 43, 42, 41, 44, 45, 41, 37, 40, 35, 40, 41, 47, 47, 30, 37, 37, 38, 40, 38, 41, 42, 47, 50, 38, 42, 39, 29, 43, 41, 36, 37, 41, 36, 41, 46, 34, 42, 23, 39, 45, 37, 42, 37, 31, 41, 42, 43, 43, 39, 42, 43, 42, 41, 43, 42, 39, 43, 16, 45, 44, 39, 37, 40, 45, 42, 42, 43, 41, 41, 44, 45, 38, 38, 41, 44, 51, 43, 34, 42, 41, 41, 27, 38, 38, 40, 42, 20, 38, 30, 38, 40, 45, 41, 37, 28, 37, 19, 41, 35, 47, 46, 40, 45, 40, 40, 40, 37, 45, 28, 47, 37, 47, 42, 45, 39, 40, 27, 39, 41, 40, 28, 43, 38, 41, 38, 41, 44, 20, 42, 33, 41, 34, 42, 40, 38, 37, 15, 48, 33, 43, 39, 47, 38, 37, 42, 43, 48, 41, 50, 40, 48, 43, 45, 22, 41, 35, 36, 37, 41, 47, 26, 29, 41, 30, 46, 41, 39, 37, 46, 46, 39, 35, 48, 40, 34, 31, 38, 39, 40, 40, 40, 41, 39, 47, 42, 47, 39, 40, 42, 45, 48, 30, 36, 34, 29, 40, 44, 32, 39, 38, 43, 40, 37, 42, 46, 48, 25, 42, 28, 25, 22, 36, 38, 47, 48, 49, 41, 42, 18, 26, 36, 41, 43, 19, 42, 42, 43, 34, 33, 34, 39, 41, 46, 46, 29, 18, 41, 39, 44, 31, 39, 18, 43, 44, 43, 42 },// 
			{ 5992, 5907, 7999, 5858, 4938, 2259, 469, 1241, 6323, 6, 4984, 1371, 4923, 7648, 7088, 1818, 36, 459, 6429, 5473, 241, 936, 6579, 6705, 8544, 7784, 4497, 9954, 476, 2459, 677, 5289, 1844, 5124, 6163, 8349, 5059, 7241, 2156, 6323, 4136, 5134, 7616, 295, 9011, 6245, 6823, 1057, 8783, 3811, 4859, 7411, 5782, 7555, 2036, 82, 782, 9354, 9166, 2371, 547, 3174, 2645, 704, 4673, 5179, 9328, 4338, 7965, 255, 287, 4536, 3481, 8146, 8473, 3873, 9115, 5583, 452, 8444, 9151, 9442, 2936, 6938, 3301, 6474, 7788, 4176, 4339, 6197, 9057, 878, 7988, 161, 496, 7095, 6007, 7208, 2681, 29, 1332, 1876, 3936, 8097, 7642, 4472, 74, 826, 5699, 2847, 1974, 3021, 113, 7207, 4788, 9594, 9783, 9987, 33, 834, 1159, 934, 7259, 7495, 2015, 6407, 5733, 6645, 316, 8639, 4397, 2965, 3677, 1355, 6357, 7666, 538, 1357, 7143, 8248, 6144, 6601, 6568, 727, 1089, 9585, 1594, 6374, 7977, 4333, 4916, 827, 9936, 475, 6174, 3495, 819, 1265, 358, 2259, 2581, 7858, 771, 5386, 7844, 8207, 8902, 6513, 7745, 3867, 5903, 9513, 9229, 577, 474, 9485, 7945, 7424, 566, 5998, 3284, 6371, 6391, 116, 8878, 39, 237, 9412, 105, 5108, 4466, 8188, 807, 8265, 888, 8205, 3315, 4828, 533, 9231, 7224, 7057, 9984, 5102, 3254, 4003, 9477, 4572, 1064, 5148, 5484, 8273, 9595, 5815, 7766, 3378, 9086, 2696, 5745, 1928, 8161, 5446, 3617, 864, 9748, 6723, 1961, 7496, 7909, 2259, 2969, 6892, 5685, 586, 1128, 834, 5375, 3414, 6274, 7639, 5518, 2213, 6873, 4534, 9625, 5677, 7972, 4728, 2723, 2303, 4926, 696, 5555, 5161, 2521, 597, 9766, 724, 5054, 4358, 4296, 9261, 7202, 5842, 4794, 7772, 7498, 5528, 245, 2235, 5503, 534, 5227, 3316, 6913, 7682, 348, 7901, 7285, 243, 6021, 5729, 5644, 1707, 6253, 4729, 6321, 4262, 5202, 6114, 7208, 3569, 9721, 2455, 3713, 1741, 343, 8088, 6273, 2368, 1344, 5726, 7243, 8827, 7077, 8235, 777, 7702, 2658, 4841, 285, 9609, 347, 6992, 6913, 4784, 195, 7798, 1564, 8322, 3309, 8097, 8767, 2106, 8003, 6478, 464, 5923, 4543, 4525, 764, 2674, 246, 9535, 4448, 6209, 6011, 4012, 5023, 218, 1902, 6168, 4421, 5519, 8214, 709, 2064, 7293, 5906, 369 }};
		
		Random rand = new Random();
		
		int k[][] = new int[3][2];  //three points with x and y coordinates  k[0][0] means 1st k.x and k[0][1] means k.y
		
	  	int newk[][] = new int[3][2]; //for calculating new value of k points.
		
		
		boolean moved0 = false, moved1 = false, moved2 = false;
		
		Points[] dataset = new Points[200];
		
		int c0=0,c1=0, c2=0;

		
		boolean choice=false;
		char ch= 'a';
		System.out.println("Please chose one.");
		System.out.println("1) Run with randomly selected 3 centroids");
		System.out.println("2) Provide k manually.");
		Scanner scan = new Scanner(System.in);
		ch = scan.next().charAt(0);		
		
		
		for(int j=0;j<200;j++){		
			dataset[j] = new Points(pts[0][j], pts[1][j]); //filling points from the int array to Point class object array
		}	
	
		
		while(ch != '1' && ch != '2'){
			System.out.println("Please input a valid choice (1 or 2).");
			ch = scan.next().charAt(0);			
		}
		
		if(ch=='1'){ //randomly run for 3 different sets of k.
			System.out.println("randomly");
		
			
			for(int repeat=1; repeat<=4; repeat++){
				for(int i=0; i<3;i++){   //generating 3 random points.
					for(int j=0;j<2;j++){
						if(j==0){
							k[i][j]= rand.nextInt(51);	//x axis should be under 51 limit
//							System.out.print( k[i][j]+ ", ");
						}
						else{
							k[i][j]= rand.nextInt(10000); //y axis should be under 10000 limit.
//							System.out.print( k[i][j]+" - ");
						}	
					
				    }
				
				}
				
			
				
				do{

				//calculating centroids for each point by calculating the shortest distance from the point to every k.	
					
					  	for(int i=0;i<200;i++){
						dataset[i].shortest = (float) Math.sqrt(Math.pow(k[0][0]-dataset[i].x, 2) + Math.pow(k[0][1]-dataset[i].y, 2) ); //distance formula
						dataset[i].cx = k[0][0]; dataset[i].cy = k[0][1]; // assigning first centroid to current point 
						
						for(int j=1;j<3;j++){	
						if(dataset[i].shortest > (float) Math.sqrt(Math.pow(k[j][0]-dataset[i].x, 2) + Math.pow(k[j][1]-dataset[i].y, 2) )){
							dataset[i].shortest = (float) Math.sqrt(Math.pow(k[j][0]-dataset[i].x, 2) + Math.pow(k[j][1]-dataset[i].y, 2) ); //saving shortest distance
						    dataset[i].cx=k[j][0];	dataset[i].cy=k[j][1];  //assigning a centroid to a point
						    }
						}
			//			      dataset[i].display();
					}	
		   	
					  	//initializing to zero so that they could be used as counters
					  	newk[0][0] = 0; newk[0][1] =0;
					  	newk[1][0] = 0; newk[1][1] =0;
					  	newk[2][0] = 0; newk[2][1] =0;
					  	c0=0; c1=0; c2=0;  
					  
					for(int i=0;i<200;i++){
						if(dataset[i].cx == k[0][0]&& dataset[i].cy == k[0][1]){	//summing up all corresponding coordinates for all k's
							newk[0][0] = newk[0][0] + dataset[i].x;
							newk[0][1] = newk[0][1] + dataset[i].y;
							c0++;
						}
						else if(dataset[i].cx == k[1][0]&&dataset[i].cy == k[1][1]){  
							newk[1][0] = newk[1][0] + dataset[i].x;
							newk[1][1] = newk[1][1] + dataset[i].y;
							c1++;
						}
						else if(dataset[i].cx == k[2][0]&&dataset[i].cy == k[2][1]){
							newk[2][0] = newk[2][0] + dataset[i].x;
							newk[2][1] = newk[2][1] + dataset[i].y;
							c2++;
						}		
				     }		
					
					
					moved0=false; moved1=false; moved2=false;
					
					if(k[0][0]!=newk[0][0] && k[0][1]!=newk[0][1]){   
						newk[0][0] = newk[0][0]/c0; newk[0][1] = newk[0][1]/c0;  //calculating the mean coordinates	of 1st K	
						moved0=true;
					}
					if(k[1][0]!=newk[1][0] && k[1][1]!=newk[1][1]){
						newk[1][0] = newk[1][0]/c1; newk[1][1] = newk[1][1]/c1;		
						moved1=true;
					}
					if(k[2][0]!=newk[2][0] && k[2][1]!=newk[2][1]){
						newk[2][0] = newk[2][0]/c2; newk[2][1] = newk[2][1]/c2;		
						moved2=true;
					}
							
					
					
					//moved0,1 and 2 has to be false if no change took place.
					if(k[0][0]==newk[0][0] && k[0][1]==newk[0][1]){
						moved0=false;
					}
					if(k[1][0]==newk[1][0] && k[1][1]==newk[1][1]){
						moved1=false;
					}
					if(k[2][0]==newk[2][0] && k[2][1]==newk[2][1]){
						moved2=false;
					}
						
					for(int i=0;i<3;i++){
						for(int j=0;j<2;j++){
							k[i][j]=newk[i][j];
						}
					}
					
					
					
			}while(moved0||moved1||moved2);		
					//System.out.print("");
				
				System.out.println("Output "+ repeat + " for randomly selected numbers");
				System.out.println(" 1st centroid	2nd centroid	3rd centroid	IV		EV		IV/EV");
				
				System.out.print(" ("+newk[0][0] +", "+ newk[0][1] +") "+ "	("+newk[1][0] +", "+ newk[1][1] +") " + "	("+newk[2][0] +", "+ newk[2][1] +")	" );
			
				float iv = 0;
				for(int i=0;i<200;i++){
					iv = iv + dataset[i].shortest; 
				}
			
				float ev=0;
				
				
				
				for(int i=0;i<200;i++){
					for(int j=0;j<200;j++){
						if(i!=j){
							ev = ev + (float) Math.sqrt(Math.pow(dataset[i].x-dataset[j].x, 2) + Math.pow(dataset[i].y-dataset[i].y, 2) ); //distance formula	
						}
						
					}
				}
				
				ev=ev/200;
				
				System.out.print(iv + "	"+ ev+ "		"+ iv/ev);
				
				//System.out.print(iv);
				
				System.out.println();
				System.out.println();
				System.out.println();
	
				
			}
			
						
		}
		else{ //Manual entry of k's
			Scanner scanner = new Scanner(System.in); 
			
			
			for(int i=0;i<3;i++){
				System.out.println("Please input the x and y coordinates for each centroids one by one.");
				
				
				
				System.out.println("input x coordinate of centroid " + (i + 1));
				k[i][0]=scanner.nextInt();
				
				System.out.println("input y coordinate of centroid " + (i +1) );
				k[i][1]=scanner.nextInt();
				
			}
	
			
			do{

			//calculating centroids for each point by calculating the shortest distance from the point to every k.	
				
				  	for(int i=0;i<200;i++){
					dataset[i].shortest = (float) Math.sqrt(Math.pow(k[0][0]-dataset[i].x, 2) + Math.pow(k[0][1]-dataset[i].y, 2) ); //distance formula
					dataset[i].cx = k[0][0]; dataset[i].cy = k[0][1]; // assigning first centroid to current point 
					
					for(int j=1;j<3;j++){	
					if(dataset[i].shortest > (float) Math.sqrt(Math.pow(k[j][0]-dataset[i].x, 2) + Math.pow(k[j][1]-dataset[i].y, 2) )){
						dataset[i].shortest = (float) Math.sqrt(Math.pow(k[j][0]-dataset[i].x, 2) + Math.pow(k[j][1]-dataset[i].y, 2) ); //saving shortest distance
					    dataset[i].cx=k[j][0];	dataset[i].cy=k[j][1];  //assigning a centroid to a point
					    }
					}
		//			      dataset[i].display();
				}	
	   	
				  	//initializing to zero so that they could be used as counters
				  	newk[0][0] = 0; newk[0][1] =0;
				  	newk[1][0] = 0; newk[1][1] =0;
				  	newk[2][0] = 0; newk[2][1] =0;
				  	c0=0; c1=0; c2=0;  
				  
				for(int i=0;i<200;i++){
					if(dataset[i].cx == k[0][0]&& dataset[i].cy == k[0][1]){	//summing up all corresponding coordinates for all k's
						newk[0][0] = newk[0][0] + dataset[i].x;
						newk[0][1] = newk[0][1] + dataset[i].y;
						c0++;
					}
					else if(dataset[i].cx == k[1][0]&&dataset[i].cy == k[1][1]){  
						newk[1][0] = newk[1][0] + dataset[i].x;
						newk[1][1] = newk[1][1] + dataset[i].y;
						c1++;
					}
					else if(dataset[i].cx == k[2][0]&&dataset[i].cy == k[2][1]){
						newk[2][0] = newk[2][0] + dataset[i].x;
						newk[2][1] = newk[2][1] + dataset[i].y;
						c2++;
					}		
			     }		
				
				
				moved0=false; moved1=false; moved2=false;
				
				if(k[0][0]!=newk[0][0] && k[0][1]!=newk[0][1]){   
					newk[0][0] = newk[0][0]/c0; newk[0][1] = newk[0][1]/c0;  //calculating the mean coordinates	of 1st K	
					moved0=true;
				}
				if(k[1][0]!=newk[1][0] && k[1][1]!=newk[1][1]){
					newk[1][0] = newk[1][0]/c1; newk[1][1] = newk[1][1]/c1;		
					moved1=true;
				}
				if(k[2][0]!=newk[2][0] && k[2][1]!=newk[2][1]){
					newk[2][0] = newk[2][0]/c2; newk[2][1] = newk[2][1]/c2;		
					moved2=true;
				}
						
				
				
				//moved0,1 and 2 has to be false if no change took place.
				if(k[0][0]==newk[0][0] && k[0][1]==newk[0][1]){
					moved0=false;
				}
				if(k[1][0]==newk[1][0] && k[1][1]==newk[1][1]){
					moved1=false;
				}
				if(k[2][0]==newk[2][0] && k[2][1]==newk[2][1]){
					moved2=false;
				}
					
				for(int i=0;i<3;i++){
					for(int j=0;j<2;j++){
						k[i][j]=newk[i][j];
					}
				}
				
				
				
		}while(moved0||moved1||moved2);		//loop has to run no change occure.
				//System.out.print("");
			
			//System.out.println("Output "+ repeat + " for randomly selected numbers");
			System.out.println(" 1st centroid	2nd centroid	3rd centroid	IV		EV		IV/EV");
			
			System.out.print(" ("+newk[0][0] +", "+ newk[0][1] +") "+ "	("+newk[1][0] +", "+ newk[1][1] +") " + "	("+newk[2][0] +", "+ newk[2][1] +")	" );
		
			float iv = 0;
			for(int i=0;i<200;i++){
				iv = iv + dataset[i].shortest; 
			}
			
			float ev=0;
			
			
			
			for(int i=0;i<200;i++){
				for(int j=0;j<200;j++){
					if(i!=j && dataset[i].cx!=dataset[j].cx && dataset[i].cy!=dataset[j].cy){
						ev = ev + (float) Math.sqrt(Math.pow(dataset[i].x-dataset[j].x, 2) + Math.pow(dataset[i].y-dataset[i].y, 2) ); //distance formula	
					}
					
				}
			}
			
			ev=ev/200;
			
			System.out.print(iv + "	"+ ev+ "		"+ iv/ev);
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	
	
	
	//not used
	static void displayk(int k[][]){
		for(int i=0; i<3;i++){
			for(int j=0;j<2;j++){
				System.out.print(k[i][j] + " ");
			}
			System.out.println();
		}
	}
	//not used.
	static void display(int points[][]){
			for(int j=0;j<200;j++){
				System.out.print(points[0][j] + " "); //x axis prints
				System.out.print(points[1][j] + " "); //y axis prints
				
				System.out.println();
		}
	}

}
