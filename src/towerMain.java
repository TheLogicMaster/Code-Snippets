
public class towerMain implements Runnable {	
	static DrawGraphics drawgraphics = new DrawGraphics();
	static CreateWindow createwindow = new CreateWindow();
	boolean running = true;
	public static void main(String[] args) {
		createwindow.makeWindow();
		
		start();
		
	}
	
	public synchronized static void start() {
		(new Thread(new towerMain())).start();
	}
	
	@Override
	public void run() {
		long now = System.currentTimeMillis();
		while(running == true){
			if (System.currentTimeMillis() / 1000 - now / 1000 >= 1/60) {
			tick();
			now = System.currentTimeMillis();

			}
			
		}
		
	}
		
	public void tick() {
		drawgraphics.tick();
		createwindow.frame.repaint();
		
	}
	
}
