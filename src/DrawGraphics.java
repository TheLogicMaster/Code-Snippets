import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class DrawGraphics extends JPanel {
	private static final long serialVersionUID = 3848437928663433161L;
	
	int x = 0;
	int y = 0;
	boolean running = true;
	
	public void paintComponent(Graphics2D g2d) {
		long now = System.currentTimeMillis();
		while(running == true){
			if (System.nanoTime() / 1000 - now / 1000 >= 1/60) {
			tick();
			render(g2d);
			System.out.println("test");
			now = System.nanoTime();

			}
			
		}
		
	}
	
	
	public void render(Graphics2D g2d) {
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(x, y, 5, 5);
		g2d.fillRect(0, 0, 500, 500);
		System.out.println("test");
	}
	
	public void tick() {
		x = (int)(Math.random() * 100);
		y = (int)(Math.random() * 100);
		
	}
	
}
