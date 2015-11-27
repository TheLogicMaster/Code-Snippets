
public class towerMain {

	public static void main(String[] args) {
		int gameLoop=1;
		long nanoTime=System.nanoTime();
		
		while(gameLoop==1){
		if (System.nanoTime()/Math.pow(10,9)-nanoTime/Math.pow(10,9)>=1/60){			
		nanoTime=System.nanoTime();
		System.out.println("1 second has elapsed");
		}
		//System.out.println(System.nanoTime()/Math.pow(10,9)+":"+(nanoTime/Math.pow(10,9)));
	}
		
		
		
	}

}
