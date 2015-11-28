
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
<<<<<<< HEAD
		long now = System.currentTimeMillis();
		while(running == true){
			if (System.currentTimeMillis() - now >= 17) {
			tick();
			now = System.currentTimeMillis();
=======
		long before = System.currentTimeMillis();
		pathGenerator pathgenerator = new pathGenerator();
		pathgenerator.curveGen(50, 50, 100, 50, 100, 100, 30);
		while (running == true) {
			if (System.currentTimeMillis() / 1000 - before / 1000 >= 1/60) {
				tick();
				before = System.currentTimeMillis();
>>>>>>> origin/master

			}

		}

	}

	public void tick() {
		drawgraphics.tick();
		createwindow.frame.repaint();

	}

}
