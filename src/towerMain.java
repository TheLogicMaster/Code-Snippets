
public class towerMain implements Runnable {
	static DrawGraphics drawgraphics = new DrawGraphics();
	boolean running = true;

	public static void main(String[] args) {
		CreateWindow.makeWindow();
		
		start();

	}

	public synchronized static void start() {
		(new Thread(new towerMain())).start();
	}

	@Override
	public void run() {
		long before = System.currentTimeMillis();
		pathGenerator pathgenerator = new pathGenerator();
		pathgenerator.curveGen(50, 50, 100, 50, 100, 100, 30);
		while (running == true) {
			
			if (System.currentTimeMillis() - before >= 17) {
				tick();
				before = System.currentTimeMillis();

			}

		}

	}

	public void tick() {
		drawgraphics.tick();
		CreateWindow.frame.repaint();

	}

}
