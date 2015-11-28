
public class towerMain {

	public static void main(String[] args) {
		CreateWindow createwindow = new CreateWindow();
		createwindow.makeWindow();
		int gameLoop=1;
		long nanoTime=System.nanoTime();
	
		while(gameLoop==1){
			if (System.nanoTime()/Math.pow(10,9)-nanoTime/Math.pow(10,9)>=1/60){			
			nanoTime=System.nanoTime();
			
<<<<<<< HEAD
			f
			
=======
			
<<<<<<< HEAD
			l
>>>>>>> origin/master
=======
			
>>>>>>> origin/master
			
		}
		//System.out.println(System.nanoTime()/Math.pow(10,9)+":"+(nanoTime/Math.pow(10,9)));
	}
		
		
		
	}

}
