import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawGraphics extends JPanel {
	private static final long serialVersionUID = -9175286406838649119L;
	public int x = 0;
	public int y = 0;
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0, 0, 0));
		tick(g2d);
		
	}
	
	public void tick(Graphics graphics) {
		x += 5;
		y += 5;
		graphics.fillRect(x, y, x + 5, y + 5);
		
	}
	
}
