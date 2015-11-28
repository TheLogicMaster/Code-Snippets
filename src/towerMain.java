
public class towerMain implements Runnable {	
	DrawGraphics drawgraphics = new DrawGraphics();
	boolean running = true;
	public static void main(String[] args) {
		CreateWindow createwindow = new CreateWindow();
		createwindow.makeWindow();
		
		start();
		//System.out.println(System.nanoTime()/Math.pow(10,9)+":"+(nanoTime/Math.pow(10,9)));
	}
	
	public synchronized static void start() {
		(new Thread(new towerMain())).start();
	}
	
	@Override
	public void run() {
		long now = System.currentTimeMillis();
		while(running == true){
			if (System.nanoTime() / 1000 - now / 1000 >= 1/60) {
			tick();
			now = System.nanoTime();

			}
			
		}
		
	}
		
	public void tick() {
		drawgraphics.tick();
		drawgraphics.repaint();
		
	}
	
}
