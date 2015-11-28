import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;


public class DrawGraphics extends Canvas {
	private static final long serialVersionUID = 3848437928663433161L;
	
	int x = 0;
	int y = 0;

	
	public void paintComponent(Graphics2D g2d) {
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(x, y, 5, 5);
		
		
	}
	
	
	public void tick() {
		x = (int)(Math.random() * 1000);
		y = (int)(Math.random() * 1000);

		
	}
	
}
