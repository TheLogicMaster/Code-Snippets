import java.awt.Graphics2D;

public class towerMain implements Runnable {
	public boolean running = true;
	public static void main(String[] args) {
		CreateWindow createwindow = new CreateWindow();
		createwindow.makeWindow();
		
		start();
	
<<<<<<< HEAD
		while(gameLoop==1){
			if (System.nanoTime()/Math.pow(10,9)-nanoTime/Math.pow(10,9)>=1/60){			
			nanoTime=System.nanoTime();
	
		}
=======
		
>>>>>>> origin/master
		//System.out.println(System.nanoTime()/Math.pow(10,9)+":"+(nanoTime/Math.pow(10,9)));
	}
		
	public synchronized static void start() {
		(new Thread(new towerMain())).start();
		
	}
		

	public void run() {
		loop();
		
	}

	public void loop() {
		DrawGraphics drawgraphics = new DrawGraphics();
		long now = System.currentTimeMillis();
		while(running == true){
			if (System.nanoTime() / 1000 - now / 1000 >= 1/60){
			drawgraphics.tick((Graphics2D)drawgraphics.getGraphics());
			System.out.println("test");
			now = System.nanoTime();

			}
		
		}
		
	}
	
}
