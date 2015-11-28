import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class DrawGraphics extends JPanel {
	private static final long serialVersionUID = 3848437928663433161L;
	
	public static int x = 0;
	public static int y = 0;

	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(x, y, 5, 5);
		
	}
	
	public void tick() {
		x = (int)(Math.random() * 1000);
		y = (int)(Math.random() * 1000);
		repaint();
		
	}
	
}
