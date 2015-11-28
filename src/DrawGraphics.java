import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class DrawGraphics extends JPanel {
	private static final long serialVersionUID = 3848437928663433161L;
	
	public static int x  = 0;
	public static int y  = 0;
	public static int xvel  = 1;
	public static int yvel  = 1;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("resources/thing.png"));
		}	catch(IOException e) {
				e.printStackTrace();
			}
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawImage(img, x, y, null);
		
	}
	
	public void tick() {
		if(x  >= 1000) {
			xvel = -xvel;
		}	else if(x < 0) {
				xvel = -xvel;
			}
		
		if(y  >= 1000) {
			yvel = -yvel;
		}	else if(y < 0) {
			yvel = -yvel;
			}
		
		x  += xvel;
		y  += yvel;
		
	}
	
}
